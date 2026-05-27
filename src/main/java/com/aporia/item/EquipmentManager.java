package com.aporia.item;

import java.util.HashMap;

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
                        10,
                        0,
                        5,
                        150
                )
        );

        registerEquipment(
                new EquipmentData(
                        "iron_armor",
                        "철갑옷",
                        EquipmentType.ARMOR,
                        0,
                        10,
                        0,
                        0
                )
        );
    }
}
