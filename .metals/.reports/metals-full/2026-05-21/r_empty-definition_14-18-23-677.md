error id: file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/player/playerData.java:
file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/player/playerData.java
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 680
uri: file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/player/playerData.java
text:
```scala
package com.aporia.player;

import java.util.UUID;

class playerData {
    // uid로 유저 데이터 관리
    private final UUID uuid;
  
    private int level;
    private long exp;
    private long attack;

    // 플레이어 데이터 초기 생성자
    public playerData(UUID uuid){
        this.uuid = uuid;
        level = 1;
        exp = 0;
        attack = 10;
    }

    // uid 반환
    public UUID getUuid(){
        return this.uuid;
    }

    // 레벨 반환
    public int getLevel(){
        return level;
    }

    // 레벨 설정
    public void setLevel(int level){
        this.level = level;
    }

    // 경험치 반환
    public long getExp(){
        return exp;
    }

    public void setExp(){
        this.exp@@
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: 