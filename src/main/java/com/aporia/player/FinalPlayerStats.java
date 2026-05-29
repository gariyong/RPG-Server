package com.aporia.player;

public class FinalPlayerStats {
    private int attack;
    private int defense;
    private int maxHealth;

    private final double critChance;
    private final double critDamage;

    public FinalPlayerStats(
        int attack,
        int defense,
        int maxHealth,
        double critChance,
        double critDamage
    ) {
        this.attack = attack;
        this.defense = defense;
        this.maxHealth = maxHealth;

        this.critChance = critChance;
        this.critDamage = critDamage;
    }

    // 공격력 반환
    public int getAttack(){
        return attack;
    }

    // 방어력 반환
    public int getDefense(){
        return defense;
    }

    // 최대 체력 반환
    public int getMaxHealth(){
        return maxHealth;
    }

    // 치명타 확률 반환
    public double getCritChance(){
        return critChance;
    }

    // 치명타 데미지 반환
    public double getCritDamage(){
        return critDamage;
    }
}
