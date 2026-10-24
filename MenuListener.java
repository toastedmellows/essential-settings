package com.example.settings;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.InventoryHolder;

public final class MenuListener implements Listener {

    private final SettingsPlugin plugin;
    private final SettingsManager manager;

    public MenuListener(SettingsPlugin plugin, SettingsManager manager) {
        this.plugin = plugin;
        this.manager = manager;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        InventoryHolder holder = event.getView().getTopInventory().getHolder(false);
        if (!(holder instanceof SettingsMenu) && !(holder instanceof LanguageMenu)) return;
        event.setCancelled(true); // nothing can be taken, placed, or shift-clicked
        if (!(event.getWhoClicked() instanceof Player player)) return;
        if (event.getClickedInventory() != event.getView().getTopInventory()) return;

        int slot = event.getRawSlot();
        if (holder instanceof SettingsMenu menu) {
            handleSettings(player, menu, slot);
        } else if (holder instanceof LanguageMenu menu) {
            handleLanguage(player, menu, slot);
        }
    }

    private void handleSettings(Player player, SettingsMenu menu, int slot) {
        if (slot == SettingsMenu.CLOSE_SLOT) {
            player.closeInventory();
            return;
        }
        if (slot == SettingsMenu.LANGUAGE_SLOT) {
            click(player, 1f);
            plugin.getServer().getScheduler().runTask(plugin, () -> new LanguageMenu(manager, player).open());
            return;
        }
        Setting setting = menu.settingAt(slot);
        if (setting == null) return;

        boolean now = manager.toggle(player, setting);
        menu.refresh();
        click(player, now ? 1.2f : 0.8f);
        if (setting == Setting.PUBLIC_CHAT && !now) {
            player.sendMessage(Component.text(manager.tr(player, "msg.public_chat_hidden"), NamedTextColor.YELLOW));
        }
    }

    private void handleLanguage(Player player, LanguageMenu menu, int slot) {
        if (slot == LanguageMenu.BACK_SLOT) {
            click(player, 1f);
            plugin.getServer().getScheduler().runTask(plugin, () -> new SettingsMenu(manager, player).open());
            return;
        }
        Lang lang = menu.langAt(slot);
        if (lang == null) return;

        manager.setLang(player, lang);
        click(player, 1.2f);
        player.sendMessage(Component.text(
                Translations.tr(lang, "lang.changed", lang.nativeName()), NamedTextColor.GREEN));
        plugin.getServer().getScheduler().runTask(plugin, () -> new SettingsMenu(manager, player).open());
    }

    private void click(Player player, float pitch) {
        player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.6f, pitch);
    }

    @EventHandler
    public void onDrag(InventoryDragEvent event) {
        InventoryHolder holder = event.getView().getTopInventory().getHolder(false);
        if (holder instanceof SettingsMenu || holder instanceof LanguageMenu) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        manager.save();
    }
}
