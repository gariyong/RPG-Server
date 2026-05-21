error id: file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/Main.java:com/aporia/Main#getServer#getPluginManager#
file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/Main.java
empty definition using pc, found symbol in pc: com/aporia/Main#getServer#getPluginManager#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 516
uri: file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/Main.java
text:
```scala
package com.aporia;

import org.bukkit.plugin.java.JavaPlugin;
import com.aporia.player.PlayerManager;
import com.aporia.command.StatsCommand;

public class Main extends JavaPlugin{
    private static Main  instance;          // 싱글톤
    private PlayerManager playerManager;    // playerManager

    @Override
    public void onEnable() {
        instance = this;
        playerManager = new PlayerManager();    // 플러그인 실행 시 playerManager 생성

         // 이벤트 리스너 등록
        getServer().getPluginManage@@r().registerEvents(new com.aporia.player.PlayerListener(), this);
        
        // 명령어 등록
        getCommand("stats").setExecutor(new StatsCommand());
        getLogger().info("MyPlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin Disabled!");
    }

    // 싱글톤 반환
    public static Main getMain(){
        return instance;
    }

    // PlayerManager 반환
    public PlayerManager getPlayerManager(){
        return playerManager;
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: com/aporia/Main#getServer#getPluginManager#