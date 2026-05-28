package com.aporia.item;

import org.bukkit.NamespacedKey;

import org.bukkit.entity.Player;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import com.aporia.Main;

import com.aporia.player.PlayerData;

public class EquipmentStatManager {
  private final NamespacedKey itemKey;

  public EquipmentStatManager(){
    itemKey = new NamespacedKey(Main.getMain(), "equipment_id");
  }

  public int getWeaponAttack(Player player){
    ItemStack item = player.getInventory().getItemInMainHand();

    if(item == null){
        return 0;
    }

    ItemMeta meta = item.getItemMeta();

    if(meta == null){
        return 0;
    }

    PersistentDataContainer container = meta.getPersistentDataContainer();
    String itemId = container.get(itemKey, PersistentDataType.STRING);
    
    if(itemId == null){
        return 0;
    }

    EquipmentData equipmentData = Main.getMain().getEquipmentManager().getEquipmentData(itemId);

    if(equipmentData == null){
        return 0;
    }

    return equipmentData.getAttack();
  }

  public int getFinalAttack(Player player, PlayerData playerData){
    return playerData.getAttack() + getWeaponAttack(player);
  }
}
