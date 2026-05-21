package com.aporia.player;

import com.aporia.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
    // 플레이어가 서버에 접속할 때마다 플레이어 데이터 생성
    Main.getMain().getPlayerManager().createPlayer(e.getPlayer().getUniqueId());
  }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){
    // 플레이어가 서버에서 나갈 때마다 플레이어 데이터 삭제
    Main.getMain().getPlayerManager().removePlayer(e.getPlayer().getUniqueId());
  }
}
