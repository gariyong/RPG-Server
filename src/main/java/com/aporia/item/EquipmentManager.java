package com.aporia.item;

import java.util.HashMap;

import org.bukkit.Material;

public class EquipmentManager {
  private final HashMap<String, EquipmentData> equipmentMap = new HashMap<>();

  public EquipmentManager(){
    registerDefaultEquipments();
  }

  // 장비 저장
  public void registerEquipment(EquipmentData equipmentData){
    equipmentMap.put(equipmentData.getId(), equipmentData);
  }

  // 장비 조회
  public EquipmentData getEquipmentData(String id){
    return equipmentMap.get(id);
  }

   // 기본 장비 등록
    private void registerDefaultEquipments() {

        registerEquipment(
                new EquipmentData(
                        "iron_sword",
                        "철검",
                        EquipmentType.WEAPON,
                        Material.IRON_SWORD,
                        10,
                        0,
                        0,
                        5,
                        0
                )
        );

        registerEquipment(
                new EquipmentData(
                        "iron_helmet",
                        "철 투구",
                        EquipmentType.ARMOR,
                        Material.IRON_HELMET,
                        0,
                        5,
                        100,
                        0,
                        0
                )
        );

        registerEquipment(
                new EquipmentData(
                        "iron_armor",
                        "철 갑옷",
                        EquipmentType.ARMOR,
                        Material.IRON_CHESTPLATE,
                        0,
                        10,
                        100,
                        0,
                        0
                )
        );

        registerEquipment(
                new EquipmentData(
                        "iron_leggings",
                        "철 레깅스",
                        EquipmentType.ARMOR,
                        Material.IRON_LEGGINGS,
                        0,
                        8,
                        100,
                        0,
                        0
                )
        );

        registerEquipment(
                new EquipmentData(
                        "iron_boots",
                        "철 신발",
                        EquipmentType.ARMOR,
                        Material.IRON_BOOTS,
                        0,
                        2,
                        100,
                        0,
                        0
                )
        );
    }
}
