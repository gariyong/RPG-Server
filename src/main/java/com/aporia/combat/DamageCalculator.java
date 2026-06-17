package com.aporia.combat;

public class DamageCalculator {
  
  // 플레이어 공격 데미지 계산
  public DamageResult calculatePlayerDamage(int attack, int defense, double critChance, double critDamage){
    int finalDamage = (int)Math.round(attack *(100.0 / (100 + defense)));
    double randomValue = Math.random() * 100;

    boolean critical = false;

    if(randomValue < critChance){
    critical = true;

    finalDamage = (int)Math.round(finalDamage * (critDamage / 100.0));
}

    return new DamageResult(finalDamage, critical);
  }

  // 몬스터 공격 데미지 계산
  public int calculateMonsterDamage(int attack, int defense) {
    return Math.max(1, (int)Math.round(attack * (100.0 / (100 + defense))));
  }
}
