error id: file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/monster/MonsterManager.java:_empty_/LivingEntity#getPersistentDataContainer#
file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/monster/MonsterManager.java
empty definition using pc, found symbol in pc: _empty_/LivingEntity#getPersistentDataContainer#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 543
uri: file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/monster/MonsterManager.java
text:
```scala
package com.aporia.monster;

import com.aporia.Main;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;

// 몬스터 데이터 설계 및 관리(나중에 MonsterData 클래스 만들어서 몬스터마다 레벨, 체력, 공격력 등 설정할 수 있게 만들 예정)
public class MonsterManager {
    // 몬스터 레벨을 저장하는 NamespacedKey
  private final NamespacedKey levelKey;

  public MonsterManager(){
    levelKey = new NamespacedKey(Main.getMain(), "monster_level");
  }

  public void setupMonster(LivingEntity monster, int level){
    PersistentDataContainer container = monster.getPersistentDataContai@@ner();
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/LivingEntity#getPersistentDataContainer#