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
    EquipmentData equipmentData = getEquipmentData(player.getInventory().getItemInMainHand());

    if(equipmentData == null){
        return 0;
    }

    return equipmentData.getAttack();
  }

  public int getFinalAttack(Player player, PlayerData playerData){
    return playerData.getAttack() + getWeaponAttack(player);
  }

  private EquipmentData getEquipmentData(ItemStack itemStack){
    if(itemStack == null){
      return null;
    }

    ItemMeta meta = itemStack.getItemMeta();

    if(meta == null){
      return null;
    }

    PersistentDataContainer container = meta.getPersistentDataContainer();
    String itemId = container.get(itemKey, PersistentDataType.STRING);

    if(itemId == null){
      return null;
    }

    return Main.getMain().getEquipmentManager().getEquipmentData(itemId);
  }

  public int getArmorDefense(Player player){
    int defense = 0;

    EquipmentData helmet = getEquipmentData(player.getInventory().getHelmet());
    EquipmentData chestplate = getEquipmentData(player.getInventory().getChestplate());
    EquipmentData leggings = getEquipmentData(player.getInventory().getLeggings());
    EquipmentData boots = getEquipmentData(player.getInventory().getBoots());

    if(helmet != null){
      defense += helmet.getDefense();
    }

    if(chestplate != null){
      defense += chestplate.getDefense();
    }

    if(leggings != null){
      defense += leggings.getDefense();
    }

    if(boots != null){
      defense += boots.getDefense();
    }

    return defense;
  }

  public int getFinalDefense(Player player, PlayerData playerData){
    return playerData.getDefense() + getArmorDefense(player);
  }

  public int getEquipmentHealth(Player player){
    int health = 0;

    EquipmentData helmet = getEquipmentData(player.getInventory().getHelmet());
    EquipmentData chestplate = getEquipmentData(player.getInventory().getChestplate());
    EquipmentData leggings = getEquipmentData(player.getInventory().getLeggings());
    EquipmentData boots = getEquipmentData(player.getInventory().getBoots());

    if(helmet != null){
      health += helmet.getMaxHealth();
    }

    if(chestplate != null){
      health += chestplate.getMaxHealth();
    }

    if(leggings != null){
      health += leggings.getMaxHealth();
    }

    if(boots != null){
      health += boots.getMaxHealth();
    }

    return health;
  }

  public int getFinalMaxHealth(Player player, PlayerData playerData){
    return playerData.getMaxHealth() + getEquipmentHealth(player);
  }
}
