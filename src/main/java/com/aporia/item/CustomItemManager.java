package com.aporia.item;

import org.bukkit.NamespacedKey;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import com.aporia.Main;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

import java.util.List;
import java.util.ArrayList;

public class CustomItemManager {
  private final NamespacedKey itemIdKey;

  public CustomItemManager(){
    itemIdKey = new NamespacedKey(Main.getMain(), "equipment_id");
  }

  public ItemStack createItem(EquipmentData equipmentData){
    ItemStack itemStack = new ItemStack(equipmentData.getMaterial());
    ItemMeta itemMeta = itemStack.getItemMeta();

    if(itemMeta == null){
        return itemStack;
    }

    // 아이템 이름 설정
    itemMeta.displayName(Component.text(equipmentData.getName()).color(NamedTextColor.GOLD));

    // 아이템 설명 설정
    List<Component>  lore = new ArrayList<>();

    // 공격력
    if(equipmentData.getAttack() != 0){
        lore.add(Component.text("공격력: +" + equipmentData.getAttack()));
    }

    // 방어력
    if(equipmentData.getDefense() != 0){
        lore.add(Component.text("방어력: +" + equipmentData.getDefense()));
    }

    // 치명타 확률
    if(equipmentData.getCritChance() != 0){
        lore.add(Component.text("치명타 확률: +" + equipmentData.getCritChance() + "%"));
    }

    // 치명타 데미지
    if(equipmentData.getCritDamage() != 0){
        lore.add(Component.text("치명타 데미지: +" + equipmentData.getCritDamage() + "%"));
    }

    itemMeta.lore(lore);

    // 아이템 ID 저장
    PersistentDataContainer container = itemMeta.getPersistentDataContainer();
    container.set(itemIdKey,PersistentDataType.STRING ,equipmentData.getId());

    itemStack.setItemMeta(itemMeta);

    return itemStack;
  }
}
