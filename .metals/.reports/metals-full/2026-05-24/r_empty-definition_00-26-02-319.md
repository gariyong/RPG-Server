error id: file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/Main.java:com/aporia/Main#getCommand#
file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/Main.java
empty definition using pc, found symbol in pc: com/aporia/Main#getCommand#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 1009
uri: file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/Main.java
text:
```scala
package com.aporia;

import org.bukkit.plugin.java.JavaPlugin;

import com.aporia.command.StatsCommand;
import com.aporia.command.ExpCommand;

import com.aporia.player.PlayerManager;
import com.aporia.level.LevelManager;


import com.aporia.data.PlayerDataStorage;

public class Main extends JavaPlugin{
    private static Main  instance;          // 싱글톤
    private PlayerManager playerManager;    // playerManager
    private PlayerDataStorage playerDataStorage; // playerDataStorage
    private LevelManager levelManager; // levelManager

    @Override
    public void onEnable() {
        instance = this;
        playerManager = new PlayerManager();    // 플러그인 실행 시 playerManager 생성
        playerDataStorage = new PlayerDataStorage(); // playerDataStorage 생성
        levelManager = new LevelManager(); // levelManager 생성

         // 이벤트 리스너 등록
        getServer().getPluginManager().registerEvents(new com.aporia.player.PlayerListener(), this);

        // 명령어 등록
        @@getCommand("스텟").setExecutor(new StatsCommand());
        getCommand("").setExecutor(new ExpCommand());
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
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: com/aporia/Main#getCommand#