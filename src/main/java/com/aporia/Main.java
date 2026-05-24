package com.aporia;

import org.bukkit.plugin.java.JavaPlugin;

import com.aporia.command.StatsCommand;
import com.aporia.command.ExpCommand;
import com.aporia.command.SpawnMobCommand;

import com.aporia.player.PlayerManager;
import com.aporia.level.LevelManager;
import com.aporia.monster.MonsterManager;

import com.aporia.player.PlayerListener;
import com.aporia.monster.MonsterListener;
import com.aporia.combat.DamageListener;

import com.aporia.data.PlayerDataStorage;

public class Main extends JavaPlugin{
    private static Main  instance;          // 싱글톤
    private PlayerManager playerManager;    // playerManager
    private PlayerDataStorage playerDataStorage; // playerDataStorage
    private LevelManager levelManager; // levelManager
    private MonsterManager monsterManager; // monsterManager

    @Override
    public void onEnable() {
        instance = this;
        playerManager = new PlayerManager();    // 플러그인 실행 시 playerManager 생성
        monsterManager = new MonsterManager(); // monsterManager 생성
        playerDataStorage = new PlayerDataStorage(); // playerDataStorage 생성
        levelManager = new LevelManager(); // levelManager 생성

         // 이벤트 리스너 등록
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getServer().getPluginManager().registerEvents(new MonsterListener(), this);
        getServer().getPluginManager().registerEvents(new DamageListener(), this);

        // 명령어 등록
        getCommand("stats").setExecutor(new StatsCommand());
        getCommand("exp").setExecutor(new ExpCommand());
        getCommand("spawnmob").setExecutor(new SpawnMobCommand());
        getLogger().info("플러그인 활성화");
    }

    @Override
    public void onDisable() {
        getLogger().info("플러그인 비활성화");
    }

    // 싱글톤 반환
    public static Main getMain(){
        return instance;
    }

    // PlayerManager 반환
    public PlayerManager getPlayerManager(){
        return playerManager;
    }

    // PlayerDataStorage 반환
    public PlayerDataStorage getPlayerDataStorage(){
        return playerDataStorage;
    }

    // LevelManager 반환
    public LevelManager getLevelManager(){
        return levelManager;
    }

    // MonsterManager 반환
    public MonsterManager getMonsterManager(){
        return monsterManager;
    }
}
