package com.aporia.player;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;

public class PlayerStatManager {
  public void applyStats(Player player, PlayerData playerData){
    AttributeInstance attribute = player.getAttribute(Attribute.MAX_HEALTH);

    if(attribute == null){
        return;
    }

    // 최대 체력 설정
    attribute.setBaseValue(playerData.getMaxHealth());

    // 현재 체력 회복
    player.setHealth(playerData.getMaxHealth());
  }
}
