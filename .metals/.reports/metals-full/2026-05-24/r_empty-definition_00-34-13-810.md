error id: file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/level/LevelManager.java:_empty_/PlayerData#getNeedExp#
file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/level/LevelManager.java
empty definition using pc, found symbol in pc: _empty_/PlayerData#getNeedExp#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 401
uri: file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/level/LevelManager.java
text:
```scala
package com.aporia.level;

import com.aporia.player.PlayerData;

public class LevelManager {
    // 경험치 추가 메소드
  public void addExp(PlayerData playerData, long exp){
    // 경험치 추가
    playerData.setExp(playerData.getExp() + exp);

    // 레벨업 체크
    checkLevelUp(playerData);
  }

    // 레벨업 체크 메소드
  private void checkLevelUp(PlayerData playerData){
    // 필요한 경험치 계산
    long needExp = playerData.get@@NeedExp();

    // 경험치가 필요한 경험치보다 많거나 같으면 레벨업
    if(needExp <= playerData.getExp()){
        // 레벨업 및 경험치 차감, 스텟 증가
        playerData.setExp(playerData.getExp() - needExp);
        playerData.setLevel(playerData.getLevel() + 1);
        playerData.setAttack(playerData.getAttack() + 5);
    }
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/PlayerData#getNeedExp#