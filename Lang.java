package com.example.settings;

import java.util.Locale;

/** Languages a player can pick in /settings. Add a new one here and in Translations. */
public enum Lang {
    EN("en", "English"),
    ES("es", "Español"),
    FR("fr", "Français"),
    DE("de", "Deutsch"),
    PT("pt", "Português"),
    IT("it", "Italiano"),
    NL("nl", "Nederlands"),
    RU("ru", "Русский"),
    PL("pl", "Polski"),
    TR("tr", "Türkçe"),
    JA("ja", "日本語"),
    KO("ko", "한국어"),
    ZH("zh", "简体中文"),
    SV("sv", "Svenska"),
    DA("da", "Dansk"),
    FI("fi", "Suomi"),
    CS("cs", "Čeština"),
    UK("uk", "Українська"),
    ID("id", "Bahasa Indonesia"),
    VI("vi", "Tiếng Việt");

    private final String code;
    private final String nativeName;

    Lang(String code, String nativeName) {
        this.code = code;
        this.nativeName = nativeName;
    }

    public String code() { return code; }
    public String nativeName() { return nativeName; }

    /** Returns null if the code isn't a supported language. */
    public static Lang fromCode(String code) {
        if (code == null) return null;
        for (Lang lang : values()) {
            if (lang.code.equalsIgnoreCase(code)) return lang;
        }
        return null;
    }

    /** Matches the player's Minecraft client language, falling back to English. */
    public static Lang fromLocale(Locale locale) {
        if (locale == null) return EN;
        Lang lang = fromCode(locale.getLanguage());
        return lang != null ? lang : EN;
    }
}
