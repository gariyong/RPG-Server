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
            config.set("defense", 5);
            config.set("maxHealth", 100);
            config.set("critChance", 0);
            config.set("critDamage", 150);
            
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

    // 추가된 스텟을 데이터에 저장
    addMissingValues(config);

    try{
        config.save(playerDataFile);
    }catch(Exception e){
        e.printStackTrace();
    }

    int level = config.getInt("level");
    long exp = config.getLong("exp");
    int attack = config.getInt("attack");
    int defense = config.getInt("defense");
    int maxHealth = config.getInt("maxHealth");
    double critChance = config.getDouble("critChance");
    double critDamage = config.getDouble("critDamage");

    // 불러온 데이터를 PlayerData 객체로 반환
    return new PlayerData(uuid, level, exp, attack, defense, maxHealth, critChance, critDamage);
  }

  public void savePlayerData(PlayerData playerData){
    // 플레이어 데이터 파일 경로
    File playerDataFile = new File(Main.getMain().getDataFolder(), "playerdatas/" + playerData.getUuid().toString() + ".yml");
    
    // 플레이어 데이터 저장
    FileConfiguration config = YamlConfiguration.loadConfiguration(playerDataFile);
    config.set("level", playerData.getLevel());
    config.set("exp", playerData.getExp());
    config.set("attack", playerData.getAttack());
    config.set("defense", playerData.getDefense());
    config.set("maxHealth", playerData.getMaxHealth());
    config.set("critChance", playerData.getCritChance());
    config.set("critDamage", playerData.getCritDamage());

    try {
        config.save(playerDataFile);
    } catch (Exception e) {
        e.printStackTrace();
    }
  }

  private void addMissingValues(FileConfiguration config){
    if (!config.contains("level")) {
        config.set("level", 1);
    }

    if (!config.contains("exp")) {
        config.set("exp", 0);
    }

    if (!config.contains("attack")) {
        config.set("attack", 10);
    }

    if (!config.contains("defense")) {
        config.set("defense", 5);
    }

    if (!config.contains("maxHealth")) {
        config.set("maxHealth", 100);
    }

    if(!config.contains("critChance")){
        config.set("critChance", 0);
    }

    if(!config.contains("critDamage")){
        config.set("critDamage", 150);
    }
  }
}