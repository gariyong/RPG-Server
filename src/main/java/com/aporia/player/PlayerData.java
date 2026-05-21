package com.aporia.player;

import java.util.UUID;

public class PlayerData {
    // uid로 유저 데이터 관리
    private final UUID uuid;
  
    private int level;
    private long exp;
    private int attack;

    // 플레이어 데이터 초기 생성자
    public PlayerData(UUID uuid){
        this.uuid = uuid;
        level = 1;
        exp = 0;
        attack = 10;
    }

    // 플레이어 데이터 전체 생성자
    public PlayerData(UUID uuid, int level, long exp, int attack){
        this.uuid = uuid;
        this.level = level;
        this.exp = exp;
        this.attack = attack;
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

    // 공격력 반환
    public int getAttack(){
        return attack;
    }

    // 공격력 설정
    public void setAttack(int attack){
        this.attack = attack;
    }
}
