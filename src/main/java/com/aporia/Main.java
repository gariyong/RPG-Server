package com.aporia;

import org.bukkit.plugin.java.JavaPlugin;

import com.aporia.command.StatsCommand;
import com.aporia.command.CraftCommand;
import com.aporia.command.ExpCommand;
import com.aporia.command.GetItemCommand;
import com.aporia.command.SpawnMobCommand;
import com.aporia.command.GiveMaterialCommand;
import com.aporia.command.GoldCommand;

import com.aporia.player.PlayerManager;
import com.aporia.level.LevelManager;
import com.aporia.monster.MonsterManager;
import com.aporia.player.PlayerStatManager;
import com.aporia.item.EquipmentManager;
import com.aporia.item.CustomItemManager;
import com.aporia.item.EquipmentStatManager;
import com.aporia.crafting.RecipeManager;
import com.aporia.item.MaterialManager;
import com.aporia.crafting.CraftManager;

import com.aporia.player.PlayerListener;
import com.aporia.monster.MonsterListener;
import com.aporia.combat.DamageCalculator;
import com.aporia.combat.DamageListener;
import com.aporia.item.EquipmentListener;

import com.aporia.data.PlayerDataStorage;

public class Main extends JavaPlugin{
    private static Main  instance;          // 싱글톤
    private PlayerManager playerManager;    // playerManager
    private PlayerDataStorage playerDataStorage; // playerDataStorage
    private LevelManager levelManager; // levelManager
    private MonsterManager monsterManager; // monsterManager
    private PlayerStatManager playerStatManager; // playerStatManager
    private DamageCalculator damageCalculator; // damageCalculator
    private EquipmentManager equipmentManager; // equipmentManager
    private CustomItemManager customItemManager; // customItemManager
    private EquipmentStatManager equipmentStatManager; // equipmentStatManager
    private RecipeManager recipeManager; // recipeManager
    private MaterialManager materialManager; // materialManager
    private CraftManager craftManager; // craftManager

    @Override
    public void onEnable() {
        instance = this;
        playerManager = new PlayerManager();    // 플러그인 실행 시 playerManager 생성
        monsterManager = new MonsterManager(); // monsterManager 생성
        playerDataStorage = new PlayerDataStorage(); // playerDataStorage 생성
        levelManager = new LevelManager(); // levelManager 생성
        playerStatManager = new PlayerStatManager(); // PlayerStatManager 생성
        damageCalculator = new DamageCalculator(); // DamageCalculator 생성
        equipmentManager = new EquipmentManager(); // EquipmentManager 생성
        customItemManager = new CustomItemManager(); // CustomItemManger 생성
        equipmentStatManager = new EquipmentStatManager(); // EquipmentStatManager 생성
        recipeManager = new RecipeManager(); // RecipeManager 생성
        materialManager = new MaterialManager(); // MaterialManager 생성
        craftManager = new CraftManager(); // CraftManager 생성

         // 이벤트 리스너 등록
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getServer().getPluginManager().registerEvents(new MonsterListener(), this);
        getServer().getPluginManager().registerEvents(new DamageListener(), this);
        getServer().getPluginManager().registerEvents(new EquipmentListener(), this);

        // 명령어 등록
        getCommand("stats").setExecutor(new StatsCommand());
        getCommand("exp").setExecutor(new ExpCommand());
        getCommand("spawnmob").setExecutor(new SpawnMobCommand());
        getCommand("getitem").setExecutor(new GetItemCommand());
        getCommand("craft").setExecutor(new CraftCommand());
        getCommand("givematerial").setExecutor(new GiveMaterialCommand());
        getCommand("gold").setExecutor(new GoldCommand());
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

    // PlayerStatManager 반환
    public PlayerStatManager getPlayerStatManager(){
        return playerStatManager;
    }

    // DamageCalculator 반환
    public DamageCalculator getDamageCalculator(){
        return damageCalculator;
    }

    // EquipmentManager 반환
    public EquipmentManager getEquipmentManager(){
        return equipmentManager;
    }

    // CustomItemManager 반환
    public CustomItemManager getCustomItemManager(){
        return customItemManager;
    }

    // EquipmentStatManager 반환
    public EquipmentStatManager getEquipmentStatManager(){
        return equipmentStatManager;
    }

    // RecipeManager 반환
    public RecipeManager getRecipeManager(){
        return recipeManager;
    }

    // MaterialManager 반환
    public MaterialManager getMaterialManager(){
        return materialManager;
    }

    // CraftManager 변환
    public CraftManager getCraftManager(){
        return craftManager;
    }
}