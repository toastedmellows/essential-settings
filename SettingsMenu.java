package com.example.settings;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** The 4-row /settings inventory. Settings on row 2, ON/OFF indicators on row 3, buttons below. */
public final class SettingsMenu implements InventoryHolder {

    private static final int SIZE = 36;
    public static final int LANGUAGE_SLOT = 30;
    public static final int CLOSE_SLOT = 32;

    private final SettingsManager manager;
    private final Player viewer;
    private final Inventory inventory;
    private final Map<Integer, Setting> slots = new HashMap<>();

    public SettingsMenu(SettingsManager manager, Player viewer) {
        this.manager = manager;
        this.viewer = viewer;
        this.inventory = Bukkit.createInventory(this, SIZE,
                Component.text(manager.tr(viewer, "menu.title"), NamedTextColor.DARK_GRAY));

        Setting[] all = Setting.values();
        int start = 9 + (9 - all.length) / 2;
        for (int i = 0; i < all.length; i++) {
            int slot = start + i;
            slots.put(slot, all[i]);
            slots.put(slot + 9, all[i]); // the indicator below is clickable too
        }
        refresh();
    }

    public void open() {
        viewer.openInventory(inventory);
    }

    public Setting settingAt(int slot) {
        return slots.get(slot);
    }

    /** Rebuilds every item from the player's current settings and language. */
    public void refresh() {
        ItemStack filler = named(Material.GRAY_STAINED_GLASS_PANE, Component.empty());
        for (int i = 0; i < SIZE; i++) {
            inventory.setItem(i, filler);
        }

        for (Map.Entry<Integer, Setting> entry : slots.entrySet()) {
            int slot = entry.getKey();
            Setting setting = entry.getValue();
            boolean on = manager.isEnabled(viewer, setting);
            if (slot < 18) {
                inventory.setItem(slot, settingItem(setting, on));
            } else {
                inventory.setItem(slot, statusItem(setting, on));
            }
        }

        Lang lang = manager.getLang(viewer);
        ItemStack language = new ItemStack(Material.COMPASS);
        language.editMeta(meta -> {
            meta.displayName(text(manager.tr(viewer, "menu.language") + ": " + lang.nativeName(),
                    NamedTextColor.AQUA).decoration(TextDecoration.BOLD, true));
            meta.lore(List.of(text(manager.tr(viewer, "menu.language.hint"), NamedTextColor.YELLOW)));
        });
        inventory.setItem(LANGUAGE_SLOT, language);

        inventory.setItem(CLOSE_SLOT, named(Material.BARRIER,
                text(manager.tr(viewer, "menu.close"), NamedTextColor.RED)));
    }

    private ItemStack settingItem(Setting setting, boolean on) {
        ItemStack item = new ItemStack(setting.icon());
        item.editMeta(meta -> {
            meta.displayName(text(manager.tr(viewer, "setting." + setting.key() + ".name"),
                    on ? NamedTextColor.GREEN : NamedTextColor.RED).decoration(TextDecoration.BOLD, true));
            List<Component> lore = new ArrayList<>();
            for (String line : wrap(manager.tr(viewer, "setting." + setting.key() + ".desc"), 34)) {
                lore.add(text(line, NamedTextColor.GRAY));
            }
            lore.add(Component.empty());
            String state = manager.tr(viewer, on ? "menu.on" : "menu.off");
            lore.add(text(manager.tr(viewer, "menu.currently", state),
                    on ? NamedTextColor.GREEN : NamedTextColor.RED));
            lore.add(text(manager.tr(viewer, "menu.toggle"), NamedTextColor.YELLOW));
            meta.lore(lore);
            meta.setEnchantmentGlintOverride(on);
        });
        return item;
    }

    private ItemStack statusItem(Setting setting, boolean on) {
        String name = manager.tr(viewer, "setting." + setting.key() + ".name");
        String state = manager.tr(viewer, on ? "menu.on" : "menu.off");
        return named(on ? Material.LIME_STAINED_GLASS_PANE : Material.RED_STAINED_GLASS_PANE,
                text(name + ": " + state, on ? NamedTextColor.GREEN : NamedTextColor.RED));
    }

    private static ItemStack named(Material material, Component name) {
        ItemStack item = new ItemStack(material);
        item.editMeta(meta -> meta.displayName(name));
        return item;
    }

    static Component text(String text, NamedTextColor color) {
        return Component.text(text, color).decoration(TextDecoration.ITALIC, false);
    }

    /** Word-wraps lore. Wide characters (Chinese, Japanese, Korean) count double and may break anywhere. */
    static List<String> wrap(String text, int max) {
        List<String> lines = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        int width = 0;
        for (String word : text.split(" ")) {
            int wordWidth = 0;
            for (char c : word.toCharArray()) wordWidth += charWidth(c);
            if (width > 0 && width + 1 + wordWidth > max) {
                lines.add(line.toString());
                line.setLength(0);
                width = 0;
            }
            if (wordWidth > max) {
                for (char c : word.toCharArray()) {
                    int cw = charWidth(c);
                    if (width + cw > max) {
                        lines.add(line.toString());
                        line.setLength(0);
                        width = 0;
                    }
                    line.append(c);
                    width += cw;
                }
                continue;
            }
            if (width > 0) {
                line.append(' ');
                width++;
            }
            line.append(word);
            width += wordWidth;
        }
        if (line.length() > 0) lines.add(line.toString());
        return lines;
    }

    private static int charWidth(char c) {
        return c >= 0x2E80 ? 2 : 1;
    }

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }
}
