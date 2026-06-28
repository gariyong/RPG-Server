package com.aporia.player;

import java.util.UUID;

public class PlayerData {
    // uid로 유저 데이터 관리
    private final UUID uuid;
  
    private int level;
    private long exp;
    private int attack;
    private int maxHealth;
    private int defense;
    private double critChance;
    private double critDamage;
    private long gold;

    // 플레이어 데이터 초기 생성자
    public PlayerData(UUID uuid){
        this.uuid = uuid;
        level = 1;
        exp = 0;
        attack = 10;
        maxHealth = 100;
        defense = 5;
        critChance = 5;
        critDamage = 150;
        gold = 0;
    }

    // 플레이어 데이터 전체 생성자
    public PlayerData(UUID uuid, int level, long exp, int attack, int defense, int maxHealth, double critChance, double critDamage, long gold){
        this.uuid = uuid;
        this.level = level;
        this.exp = exp;
        this.attack = attack;
        this.defense = defense;
        this.maxHealth = maxHealth;
        this.critChance = critChance;
        this.critDamage = critDamage;
        this.gold = gold;
    }

    // uid 반환
    public UUID getUuid(){
        return this.uuid;
    }

    // 레벨 반환
    public int getLevel(){
        return level;
    }

    // 레벨 설정
    public void setLevel(int level){
        this.level = level;
    }

    // 경험치 반환
    public long getExp(){
        return exp;
    }

    // 경험치 설정
    public void setExp(long exp){
        this.exp = exp;
    }

    public long getNeedExp(){
        return level * 1000L; // 예시로 레벨당 필요한 경험치를 1000으로 설정
    }

    // 공격력 반환
    public int getAttack(){
        return attack;
    }

    // 공격력 설정
    public void setAttack(int attack){
        this.attack = attack;
    }

    // 방어력 반환
    public int getDefense(){
        return defense;
    }

    // 방어력 설정
    public void setDefense(int defense){
        this.defense = defense;
    }

    // 최대 체력 반환
    public int getMaxHealth(){
        return maxHealth;
    }

    // 최대 체력 설정
    public void setMaxHealth(int maxHealth){
        this.maxHealth = maxHealth;
    }

    // 치명타 확률 반환
    public double getCritChance(){
        return critChance;
    }

    // 치명타 확률 설정
    public void setCritChance(double critChance){
        this.critChance = critChance;
    }

    // 치명타 데미지 반환
    public double getCritDamage(){
        return critDamage;
    }

    // 치명타 데미지 설정
    public void setCritDamage(double critDamage){
        this.critDamage = critDamage;
    }

    // 골드 반환
    public long getGold(){
        return gold;
    }

    // 골드 설정
    public void setGold(long gold){
        this.gold = Math.max(0, gold);
    }

    // 골드 추가
    public void addGold(long amount){
        setGold(this.gold + amount);
    }

    // 골드 차감 (성공 여부 반환)
    public boolean removeGold(long amount){
        if(this.gold < amount){
            return false;
        }

        this.gold -= amount;
        return true;
    }
}