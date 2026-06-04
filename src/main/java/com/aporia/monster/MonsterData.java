package com.aporia.monster;

import java.util.List;

public class MonsterData{
    private final String id;
    private final String name;

    private final int level;

    private final int attack;
    private final int defense;
    private final int maxHealth;

    private final long exp;

    private final List<DropData> drops;

    MonsterData(String id, String name, int level, int attack, int defense, int maxHealth, long exp, List<DropData> drops){
        this.id = id;
        this.name = name;
        
        this.level = level;

        this.attack = attack;
        this.defense = defense;
        this.maxHealth = maxHealth;
        
        this.exp = exp;

        this.drops = drops;
    }

    // 몬스터 id 반환
    public String getId(){
        return id;
    }

    // 몬스터 이름 반환
    public String getName(){
        return name;
    }

    // 몬스터 레벨 반환
    public int getLevel(){
        return level;
    }

    // 몬스터 공격력 반환
    public int getAttack(){
        return attack;
    }

    // 몬스터 방어력 반환
    public int getDefense(){
        return defense;
    }

    // 몬스터 최대 체력 반환
    public int getMaxHealth(){
        return maxHealth;
    }

    // 몬스터 경험치 반환
    public long getExp(){
        return exp;
    }

    // 몬스터 드랍 테이블 반환
    public List<DropData> getDrops(){
        return drops;
    }
}