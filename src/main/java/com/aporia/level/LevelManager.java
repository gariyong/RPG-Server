package com.aporia.level;

import com.aporia.player.PlayerData;

public class LevelManager {
    // 경험치 추가 메소드
  public void addExp(PlayerData playerData, long exp){
    // 경험치 추가
    playerData.setExp(playerData.getExp() + exp);

    // 레벨업 체크
    checkLevelUp(playerData);
  }

    // 레벨업 체크 메소드
  private void checkLevelUp(PlayerData playerData){
    // 필요한 경험치 계산
    long needExp = playerData.getNeedExp();

    // 경험치가 필요한 경험치보다 많거나 같으면 레벨업
    if(needExp <= playerData.getExp()){
        // 레벨업 및 경험치 차감, 스텟 증가
        playerData.setExp(playerData.getExp() - needExp);
        playerData.setLevel(playerData.getLevel() + 1);
        playerData.setAttack(playerData.getAttack() + 5);
    }
  }
}
