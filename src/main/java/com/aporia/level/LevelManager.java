package com.aporia.level;

import com.aporia.Main;
import com.aporia.player.PlayerData;

import net.kyori.adventure.text.format.NamedTextColor;

import org.bukkit.entity.Player;
import net.kyori.adventure.text.Component;

public class LevelManager {
    // 경험치 추가 메소드
  public void addExp(Player player,PlayerData playerData, long exp){
    // 경험치 추가
    playerData.setExp(playerData.getExp() + exp);

    // 레벨업 체크
    checkLevelUp(player, playerData);
  }

    // 레벨업 체크 메소드
  private void checkLevelUp(Player player, PlayerData playerData){

    // 필요한 경험치보다 현재 경험치가 많으면 레벨업
    while(true){
        // 필요한 경험치 계산
        long needExp = playerData.getNeedExp();

        // 필요한 경험치보다 현재 경험치가 적으면 레벨업 종료
        if(needExp > playerData.getExp()){
            break;
        }

        // 필요한 경험치보다 현재 경험치가 많으면 레벨업 및 경험치 차감, 스텟 증가
        if(needExp <= playerData.getExp()){
            playerData.setExp(playerData.getExp() - needExp);
            playerData.setLevel(playerData.getLevel() + 1);

            playerData.setAttack(playerData.getAttack() + 5);
            playerData.setMaxHealth(playerData.getMaxHealth() + 20);
            playerData.setDefense(playerData.getDefense() + 1);

            // 수정된 스텟을 데이터에 저장
            Main.getMain().getPlayerStatManager().applyStats(player, playerData);

            // 레벨업 메시지 출력
            player.sendMessage(Component.text("레벨업!").color(NamedTextColor.GOLD));
            player.sendMessage(Component.text("현재 레벨: " + playerData.getLevel()).color(NamedTextColor.YELLOW));
        }
    } 
 }
}
