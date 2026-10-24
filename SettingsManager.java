package com.example.settings;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;

/** Stores each player's settings and language in plugins/Settings/playerdata.yml. Thread-safe for reads. */
public final class SettingsManager {

    private final SettingsPlugin plugin;
    private final File file;
    private final Map<UUID, Map<Setting, Boolean>> data = new ConcurrentHashMap<>();
    private final Map<UUID, Lang> languages = new ConcurrentHashMap<>();
    private volatile boolean dirty;

    public SettingsManager(SettingsPlugin plugin) {
        this.plugin = plugin;
        this.file = new File(plugin.getDataFolder(), "playerdata.yml");
    }

    public void load() {
        data.clear();
        languages.clear();
        if (!file.exists()) return;
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);
        ConfigurationSection players = yaml.getConfigurationSection("players");
        if (players == null) return;
        for (String id : players.getKeys(false)) {
            UUID uuid;
            try {
                uuid = UUID.fromString(id);
            } catch (IllegalArgumentException e) {
                continue;
            }
            ConfigurationSection section = players.getConfigurationSection(id);
            if (section == null) continue;
            for (Setting setting : Setting.values()) {
                if (section.isBoolean(setting.key())) {
                    values(uuid).put(setting, section.getBoolean(setting.key()));
                }
            }
            Lang lang = Lang.fromCode(section.getString("language"));
            if (lang != null) languages.put(uuid, lang);
        }
    }

    public synchronized void save() {
        if (!dirty) return;
        dirty = false;
        YamlConfiguration yaml = new YamlConfiguration();
        Set<UUID> ids = new HashSet<>(data.keySet());
        ids.addAll(languages.keySet());
        for (UUID id : ids) {
            Map<Setting, Boolean> settings = data.get(id);
            if (settings != null) {
                for (Map.Entry<Setting, Boolean> value : settings.entrySet()) {
                    yaml.set("players." + id + "." + value.getKey().key(), value.getValue());
                }
            }
            Lang lang = languages.get(id);
            if (lang != null) {
                yaml.set("players." + id + ".language", lang.code());
            }
        }
        try {
            plugin.getDataFolder().mkdirs();
            yaml.save(file);
        } catch (IOException e) {
            dirty = true;
            plugin.getLogger().log(Level.SEVERE, "Could not save playerdata.yml", e);
        }
    }

    private Map<Setting, Boolean> values(UUID uuid) {
        return data.computeIfAbsent(uuid, k -> new ConcurrentHashMap<>());
    }

    public boolean isEnabled(UUID uuid, Setting setting) {
        Map<Setting, Boolean> map = data.get(uuid);
        if (map == null) return setting.defaultValue();
        return map.getOrDefault(setting, setting.defaultValue());
    }

    public boolean isEnabled(Player player, Setting setting) {
        return isEnabled(player.getUniqueId(), setting);
    }

    /** Flips the setting and returns the new value. */
    public boolean toggle(Player player, Setting setting) {
        boolean newValue = !isEnabled(player, setting);
        values(player.getUniqueId()).put(setting, newValue);
        dirty = true;
        return newValue;
    }

    /** The player's chosen language, or their Minecraft client language if they never picked one. */
    public Lang getLang(Player player) {
        Lang lang = languages.get(player.getUniqueId());
        return lang != null ? lang : Lang.fromLocale(player.locale());
    }

    public void setLang(Player player, Lang lang) {
        languages.put(player.getUniqueId(), lang);
        dirty = true;
    }

    /** Translates a message into the player's language. */
    public String tr(Player player, String key, Object... args) {
        return Translations.tr(getLang(player), key, args);
    }

    /**
     * Sends a message to everyone (and the console) who has the given setting on
     * and has not turned off All Chat Messages.
     */
    public void broadcast(Setting setting, Component message) {
        for (Player online : Bukkit.getOnlinePlayers()) {
            if (isEnabled(online, setting) && isEnabled(online, Setting.ALL_CHAT)) {
                online.sendMessage(message);
            }
        }
        Bukkit.getConsoleSender().sendMessage(message);
    }
}
