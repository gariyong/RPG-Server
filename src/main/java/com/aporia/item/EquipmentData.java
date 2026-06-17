package com.aporia.item;

import org.bukkit.Material;

public class EquipmentData {
  private final String id;
  private final String name;
  private final EquipmentType type;
  private final Material material;
 
  private final int attack;
  private final int defense;
  private final int maxHealth;
  
  private final double critChance;
  private final double critDamage;

  private final Rarity rarity;

  public EquipmentData(String id, 
    String name, 
    EquipmentType type, 
    Rarity rarity,
    Material material, 
    int attack, 
    int defense, 
    int maxHealth,
    double critChance, 
    double critDamage
  )
    {
    this.id = id;
    this.name = name;
    this.rarity = rarity;
    this.type = type;
    this.material = material;

    this.attack = attack;
    this.defense = defense;
    this.maxHealth = maxHealth;

    this.critChance = critChance;
    this.critDamage = critDamage;
  }

  // 장비 id 반환
  public String getId(){
    return id;
  }

  // 장비 이름 반환
  public String getName(){
    return name;
  }

  // 장비 종류 반환
  public EquipmentType getType(){
    return type;
  }

  // 장비 material 반환
  public Material getMaterial(){
    return material;
  }

  // 장비 공격력 반환
  public int getAttack(){
    return attack;
  }

  // 장비 방어력 반환
  public int getDefense(){
    return defense;
  }

  // 장비 최대 체력 반환
  public int getMaxHealth(){
    return maxHealth;
  }

  // 장비 치명타 확률 반환
  public double getCritChance(){
    return critChance;
  }

  // 장비 치명타 데미지 반환
  public double getCritDamage(){
    return critDamage;
  }

  // 장비 등급 반환
  public Rarity getRarity(){
    return rarity;
  }
}
