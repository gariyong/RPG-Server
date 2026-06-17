package com.aporia.item;

import net.kyori.adventure.text.format.NamedTextColor;

public enum Rarity {
    COMMON(
        "일반",
        NamedTextColor.WHITE
    ),

    UNCOMMON(
        "고급",
        NamedTextColor.GREEN
    ),

    RARE(
        "희귀",
        NamedTextColor.BLUE
    ),

    EPIC(
        "영웅",
        NamedTextColor.DARK_PURPLE
    ),

    LEGENDARY(
        "전설",
        NamedTextColor.GOLD
    );

    private final String displayName;
    private final NamedTextColor color;

    Rarity(String displayName, NamedTextColor color){
        this.displayName = displayName;
        this.color = color;
    }

    public String getDisplayName(){
        return displayName;
    }

    public NamedTextColor getColor(){
        return color;
    }
}
