package com.aporia;

import org.bukkit.plugin.java.JavaPlugin;
import com.aporia.player.PlayerManager;
import com.aporia.command.StatsCommand;
import com.aporia.data.PlayerDataStorage;

public class Main extends JavaPlugin{
    private static Main  instance;          // 싱글톤
    private PlayerManager playerManager;    // playerManager
    private PlayerDataStorage playerDataStorage; // playerDataStorage

    @Override
    public void onEnable() {
        instance = this;
        playerManager = new PlayerManager();    // 플러그인 실행 시 playerManager 생성
        playerDataStorage = new PlayerDataStorage(); // playerDataStorage 생성

         // 이벤트 리스너 등록
        getServer().getPluginManager().registerEvents(new com.aporia.player.PlayerListener(), this);

        // 명령어 등록
        getCommand("스텟").setExecutor(new StatsCommand());
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
}
