package com.aporia.monster;

import com.aporia.Main;

import net.kyori.adventure.text.Component;

import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.attribute.AttributeInstance;

// 몬스터 데이터 설계 및 관리(나중에 MonsterData 클래스 만들어서 몬스터마다 레벨, 체력, 공격력 등 설정할 수 있게 만들 예정)
public class MonsterManager {
    // 몬스터 레벨을 저장하는 NamespacedKey
  private final NamespacedKey levelKey;
  private final NamespacedKey defenseKey;

  public MonsterManager(){
    levelKey = new NamespacedKey(Main.getMain(), "monster_level");
    defenseKey = new NamespacedKey(Main.getMain(), "monster_defense");
  }

  // 몬스터 특성 설정
  public void setupMonster(LivingEntity entity, int level){
    int defense = level * 3;
    
    // 몬스터의 레벨을 PersistentDataContainer에 저장
    PersistentDataContainer container = entity.getPersistentDataContainer();
    container.set(levelKey, PersistentDataType.INTEGER, level);
    container.set(defenseKey, PersistentDataType.INTEGER, defense);

    double maxHealth = 20 + (level - 1) * 5; // 레벨에 따라 최대 체력 증가
    AttributeInstance attribute = entity.getAttribute(Attribute.MAX_HEALTH); // 몬스터의 최대 체력 속성 가져오기

    // 최대 체력 설정
    if(attribute != null){
      attribute.setBaseValue(maxHealth);
    }

    entity.setHealth(maxHealth); // 현재 체력도 최대 체력으로 설정
    entity.customName(Component.text("[Lv. " + level + "] " + entity.getName())); // 몬스터 이름에 레벨 표시

    // 몬스터 이름이 항상 보이도록 설정
    entity.setCustomNameVisible(true);
  }

  // 몬스터 레벨 반환
  public int getMonsterLevel(LivingEntity entity){
    PersistentDataContainer container = entity.getPersistentDataContainer();

    Integer level = container.get(levelKey, PersistentDataType.INTEGER);

    if(level == null){
      return 1;
    }

    return level;
  }

  public int getMonsterDefense(LivingEntity entity){
    PersistentDataContainer container = entity.getPersistentDataContainer();

    Integer defense = container.get(defenseKey, PersistentDataType.INTEGER);

    if(defense == null){
      return 0;
    }

    return defense;
  }
}
