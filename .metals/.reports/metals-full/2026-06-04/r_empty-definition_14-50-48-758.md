error id: file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/monster/MonsterManager.java:_empty_/levelKey#
file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/monster/MonsterManager.java
empty definition using pc, found symbol in pc: _empty_/levelKey#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 2338
uri: file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/monster/MonsterManager.java
text:
```scala
package com.aporia.monster;

import com.aporia.Main;

import net.kyori.adventure.text.Component;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.attribute.AttributeInstance;

// 몬스터 데이터 설계 및 관리(나중에 MonsterData 클래스 만들어서 몬스터마다 레벨, 체력, 공격력 등 설정할 수 있게 만들 예정)
public class MonsterManager {
  private final NamespacedKey idKey;

  private final HashMap<UUID, UUID> lastAttackerMap = new HashMap<>();
  private final HashMap<String, MonsterData>monsterDataMap = new HashMap<>();

  public MonsterManager(){
    levelKey = new NamespacedKey(Main.getMain(), "monster_level");
    defenseKey = new NamespacedKey(Main.getMain(), "monster_defense");

    monsterDataMap.put(
      "zombie",
      new MonsterData(
        "zimbie",
        "좀비",
        1,
        5, 
        0, 
        50, 
        10
      )
    );

    monsterDataMap.put(
      "skeleton",
      new MonsterData(
        "skeleton", 
        "스켈레톤", 
        5,
        10, 
        5, 
        100, 
        20
      )
    );
  }

  // 몬스터 특성 설정
  public void setupMonster(LivingEntity entity, String id){    
    PersistentDataContainer container = entity.getPersistentDataContainer();
    MonsterData data = getMonsterData(id);

    if(data == null){
      return;
    }

    int attack = data.getAttack();
    int defense = data.getDefense();
    int maxHealth = data.getMaxHealth();

    AttributeInstance attribute = entity.getAttribute(Attribute.MAX_HEALTH); // 몬스터의 최대 체력 속성 가져오기

    // 최대 체력 설정
    if(attribute != null){
      attribute.setBaseValue(maxHealth);
    }

    entity.setHealth(maxHealth); // 현재 체력도 최대 체력으로 설정
    entity.customName(Component.text("[Lv. " + data.getLevel() + "] " + data.getName())); // 몬스터 이름에 레벨 표시

    // 몬스터 이름이 항상 보이도록 설정
    entity.setCustomNameVisible(true);
  }

  // 몬스터 레벨 반환
  public int getMonsterLevel(LivingEntity entity){
    PersistentDataContainer container = entity.getPersistentDataContainer();

    Integer level = container.get(leve@@lKey, PersistentDataType.INTEGER);

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

  public void setLastAttacker(LivingEntity monster, Player player){
    lastAttackerMap.put(monster.getUniqueId(), player.getUniqueId());
  }

  public Player getLastAttacker(LivingEntity monster){
    UUID playerUUID = lastAttackerMap.get(monster.getUniqueId());

    if(playerUUID == null){
      return null;
    }

    return Bukkit.getPlayer(playerUUID);
  }

  public void removeLastAttacker(LivingEntity monster){
    lastAttackerMap.remove(monster.getUniqueId());
  }

  public MonsterData getMonsterData(String id){
    return monsterDataMap.get(id);
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/levelKey#