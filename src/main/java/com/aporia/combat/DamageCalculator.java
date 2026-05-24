package com.aporia.combat;

import com.aporia.player.PlayerData;

public class DamageCalculator {
  // 플레이어 공격 데미지 계산
  public double calculatePlayerDamage(PlayerData playerData){
    return playerData.getAttack();
  }

  // 몬스터 공격 데미지 계산
  public double calculateMonsterDamage(int monsterLevel){
    return monsterLevel * 5;
  }
}
