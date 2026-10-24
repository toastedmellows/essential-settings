package com.example.settings;

import org.bukkit.Material;

/**
 * Every toggle shown in the /settings menu. Names and descriptions come from Translations
 * using the keys "setting.<key>.name" and "setting.<key>.desc". The menu lays itself out
 * automatically (up to 9 settings).
 */
public enum Setting {
    ALL_CHAT("all_chat", Material.WRITABLE_BOOK, true),
    PUBLIC_CHAT("public_chat", Material.PAPER, true),
    JOIN_QUIT("join_quit", Material.OAK_DOOR, true),
    TPA_REQUESTS("tpa_requests", Material.ENDER_PEARL, true),
    ADVANCEMENTS("advancements", Material.EXPERIENCE_BOTTLE, true),
    MENTION_SOUND("mention_sound", Material.NOTE_BLOCK, true);

    private final String key;
    private final Material icon;
    private final boolean defaultValue;

    Setting(String key, Material icon, boolean defaultValue) {
        this.key = key;
        this.icon = icon;
        this.defaultValue = defaultValue;
    }

    public String key() { return key; }
    public Material icon() { return icon; }
    public boolean defaultValue() { return defaultValue; }
}
