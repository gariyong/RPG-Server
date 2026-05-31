package com.aporia.monster;

public class DropData {
    private final String itemId;
    private final double chance;

    public DropData(String itemId, double chance){
        this.itemId = itemId;
        this.chance = chance;
    }

    public String getItemId(){
        return itemId;
    }

    public double getChance(){
        return chance;
    }
}
