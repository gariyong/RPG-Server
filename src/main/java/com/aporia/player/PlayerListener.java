package com.aporia.player;

import com.aporia.Main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import java.util.UUID;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        // 플레이어 uuid
        UUID uuid = e.getPlayer().getUniqueId();

        Main.getMain().getPlayerDataStorage().createPlayerData(uuid); // 플레이어 데이터 파일 생성
        PlayerData playerData = Main.getMain().getPlayerDataStorage().loadPlayerData(uuid); // 플레이어 데이터 불러오기
        Main.getMain().getPlayerManager().createPlayer(playerData); // 플레이어 데이터 매니저에 저장
  }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){
    // 플레이어가 서버에서 나갈 때마다 플레이어 데이터 삭제
    Main.getMain().getPlayerManager().removePlayer(e.getPlayer().getUniqueId());
  }
}
