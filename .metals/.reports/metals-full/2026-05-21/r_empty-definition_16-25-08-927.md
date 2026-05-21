error id: file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/data/PlayerDataStorage.java:_empty_/Yaml#loadConfiguration#
file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/data/PlayerDataStorage.java
empty definition using pc, found symbol in pc: _empty_/Yaml#loadConfiguration#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 1255
uri: file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/data/PlayerDataStorage.java
text:
```scala
package com.aporia.data;

import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import com.aporia.Main;
import com.aporia.player.PlayerData;

public class PlayerDataStorage {
    // 플레이어 데이터 저장 메소드
  public void createPlayerData(UUID uuid){
    // 플레이어 데이터 저장 폴더 생성
    File folder = new File(Main.getMain().getDataFolder(), "playerdatas");

    // 폴더가 존재하지 않으면 생성
    if (!folder.exists()) {
        folder.mkdirs();
    }

    // 플레이어 데이터 파일 생성
    File playerDataFile = new File(folder, uuid.toString() + ".yml");
    
    // 파일이 존재하지 않으면 생성하고 초기값 설정
    if (!playerDataFile.exists()) {
        try {
            playerDataFile.createNewFile();
            
            FileConfiguration config = Main.getMain().getConfig();
            config.set("level", 1);
            config.set("exp", 0);
            config.set("attack", 10);
            config.save(playerDataFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  }

  public PlayerData loadPlayerData(UUID uuid){
    File playerDataFile = new File(Main.getMain().getDataFolder(), "playerdatas/" + uuid.toString() + ".yml");
    
    FileConfiguration config = Yaml.loadConfigur@@ation(playerDataFile);
    int level = config.getInt("level");
    long exp = config.getLong("exp");
    int attack = config.getInt("attack");
  }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/Yaml#loadConfiguration#