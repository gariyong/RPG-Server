package com.aporia.item;

import org.bukkit.NamespacedKey;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.aporia.Main;

public class CustomItemManager {
  private final NamespacedKey itemIdKey;

  public CustomItemManager(){
    itemIdKey = new NamespacedKey(Main.getMain(), "equipment_id");
  }

  public ItemStack createItem(EquipmentData equipmentData){
    ItemStack itemStack = new ItemStack(equipmentData.getMaterial());
    ItemMeta itemMeta = itemStack.getItemMeta();

    

    return itemStack;
  }
}
