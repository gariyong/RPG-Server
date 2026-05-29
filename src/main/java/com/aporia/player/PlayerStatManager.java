package com.aporia.player;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;

import com.aporia.Main;

public class PlayerStatManager {
  public void applyStats(Player player, PlayerData playerData){

    // Attribute 가져오기
    AttributeInstance attribute = player.getAttribute(Attribute.MAX_HEALTH);

    if(attribute == null){
        return;
    }

    // 최대 체력 설정
    int finalHealth = Main.getMain().getEquipmentStatManager().getFinalMaxHealth(player, playerData);
    attribute.setBaseValue(finalHealth);

    // 현재 체력 회복
    player.setHealth(finalHealth);
  }
}
