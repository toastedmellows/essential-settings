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

import java.util.List;

/** Language picker. One item per language (up to 27), a back button on the bottom row. */
public final class LanguageMenu implements InventoryHolder {

    private static final int SIZE = 36;
    public static final int BACK_SLOT = 31;

    private final SettingsManager manager;
    private final Player viewer;
    private final Inventory inventory;

    public LanguageMenu(SettingsManager manager, Player viewer) {
        this.manager = manager;
        this.viewer = viewer;
        this.inventory = Bukkit.createInventory(this, SIZE,
                Component.text(manager.tr(viewer, "lang.title"), NamedTextColor.DARK_GRAY));
        refresh();
    }

    public void open() {
        viewer.openInventory(inventory);
    }

    /** The language at this slot, or null. */
    public Lang langAt(int slot) {
        Lang[] all = Lang.values();
        return slot >= 0 && slot < all.length && slot < 27 ? all[slot] : null;
    }

    private void refresh() {
        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        filler.editMeta(meta -> meta.displayName(Component.empty()));
        for (int i = 0; i < SIZE; i++) {
            inventory.setItem(i, filler);
        }

        Lang current = manager.getLang(viewer);
        Lang[] all = Lang.values();
        for (int i = 0; i < all.length && i < 27; i++) {
            Lang lang = all[i];
            boolean selected = lang == current;
            ItemStack item = new ItemStack(selected ? Material.LIME_DYE : Material.PAPER);
            item.editMeta(meta -> {
                meta.displayName(SettingsMenu.text(lang.nativeName(),
                        selected ? NamedTextColor.GREEN : NamedTextColor.WHITE).decoration(TextDecoration.BOLD, true));
                meta.lore(List.of(selected
                        ? SettingsMenu.text(manager.tr(viewer, "lang.selected"), NamedTextColor.GREEN)
                        : SettingsMenu.text(manager.tr(viewer, "lang.click"), NamedTextColor.YELLOW)));
                meta.setEnchantmentGlintOverride(selected);
            });
            inventory.setItem(i, item);
        }

        ItemStack back = new ItemStack(Material.ARROW);
        back.editMeta(meta -> meta.displayName(
                SettingsMenu.text(manager.tr(viewer, "lang.back"), NamedTextColor.RED)));
        inventory.setItem(BACK_SLOT, back);
    }

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }
}
