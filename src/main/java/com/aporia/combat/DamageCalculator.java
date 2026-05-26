package com.aporia.combat;

public class DamageCalculator {
  
  // 플레이어 공격 데미지 계산
  public double calculatePlayerDamage(int attack, int defense, double critChance, double critDamage){
    double finalAttack = attack *(100.0 / (100 + defense));
    double randomValue = Math.random() * 100;

    if(randomValue < critChance){
      finalAttack *= (critDamage / 100.0);
    }

    return finalAttack;
  }

  // 몬스터 공격 데미지 계산
  public double calculateMonsterDamage(int attack, int defense) {
    return attack * (100.0 / (100 + defense));
  }
}
