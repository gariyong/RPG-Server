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

    // 스텟 가져와서 적용
    FinalPlayerStats stats = Main.getMain().getEquipmentStatManager().calculateStats(player, playerData);
    
    // 현재 최대 체력
    double oldMaxHealth = attribute.getBaseValue();

    // 현재 체력
    double currentHealth = player.getHealth();

    // 체력 비율 계산
    double healthPercent = currentHealth / oldMaxHealth;

    // 최대 체력 변경
    attribute.setBaseValue(stats.getMaxHealth());

    // 새 체력 계산
    double newHealth = stats.getMaxHealth() * healthPercent;

    // 범위 보정
    newHealth = Math.min(newHealth, stats.getMaxHealth());

    player.setHealth(Math.max(0, newHealth));
  }
}
