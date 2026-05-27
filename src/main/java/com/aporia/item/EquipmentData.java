package com.aporia.item;

public class EquipmentData {
  private final String id;
  private final String name;
  private final EquipmentType type;
 
  private final int attack;
  private final int defense;
  
  private final double critChance;
  private final double critDamage;

  public EquipmentData(String id, String name, EquipmentType type, int attack, int defense, double critChance, double critDamage){
    this.id = id;
    this.name = name;
    this.type = type;

    this.attack = attack;
    this.defense = defense;

    this.critChance = critChance;
    this.critDamage = critDamage;
  }

  // 장비 id 반환
  String getId(){
    return id;
  }

  // 장비 이름 반환
  String getName(){
    return name;
  }

  // 장비 종류 반환
  EquipmentType getType(){
    return type;
  }

  // 장비 공격력 반환
  int getAttack(){
    return attack;
  }

  // 장비 방어력 반환
  int getDefense(){
    return defense;
  }

  // 장비 치명타 확률 반환
  double getCritChance(){
    return critChance;
  }

  // 장비 치명타 데미지 반환
  double getCritDamage(){
    return critDamage;
  }
}
