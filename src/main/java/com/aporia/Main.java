package com.aporia;

import org.bukkit.plugin.java.JavaPlugin;
import com.aporia.player.PlayerManager;

public class Main extends JavaPlugin{
    private static Main  instance;          // 싱글톤
    private PlayerManager playerManager;    // playerManager

    @Override
    public void onEnable() {
        instance = this;
        playerManager = new PlayerManager();    // 플러그인 실행 시 playerManager 생성

        getLogger().info("MyPlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin Disabled!");
    }

    // Main 싱글톤 반환
    public static Main getMain(){
        return instance;
    }

    // PlayerManager 반환
    public PlayerManager getPlayerManager(){
        return playerManager;
    }
}
