error id: file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/data/PlayerDataStorage.java:_empty_/FileConfiguration#
file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/data/PlayerDataStorage.java
empty definition using pc, found symbol in pc: _empty_/FileConfiguration#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 1850
uri: file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/data/PlayerDataStorage.java
text:
```scala
package com.aporia.data;

import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

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
            
            FileConfiguration config = YamlConfiguration.loadConfiguration(playerDataFile);
            config.set("level", 1);
            config.set("exp", 0);
            config.set("attack", 10);
            config.save(playerDataFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  }

  // 플레이어 데이터 불러오기 메소드
  public PlayerData loadPlayerData(UUID uuid){
    // 플레이어 데이터 파일 경로
    File playerDataFile = new File(Main.getMain().getDataFolder(), "playerdatas/" + uuid.toString() + ".yml");
    
    // 플레이어 데이터 불러오기
    FileConfiguration config = YamlConfiguration.loadConfiguration(playerDataFile);
    int level = config.getInt("level");
    long exp = config.getLong("exp");
    int attack = config.getInt("attack");

    // 불러온 데이터를 PlayerData 객체로 반환
    return new PlayerData(uuid, level, exp, attack);
  }

  public void savePlayerData(PlayerData playerData){
    // 플레이어 데이터 파일 경로
    File playerDataFile = new File(Main.getMain().getDataFolder(), "playerdatas/" + playerData.getUuid().toString() + ".yml");
    
    // 플레이어 데이터 저장
    F@@ileConfiguration config = YamlConfiguration.loadConfiguration(playerDataFile);
    config.set("Level", playerData.getLevel());
    config.set("Exp", playerData.getExp());
    config.set("Attack", playerData.getAttack());

    try {
        config.save(playerDataFile);
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/FileConfiguration#