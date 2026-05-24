package com.aporia.player;

import com.aporia.Main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import java.util.UUID;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        // 플레이어
        Player player = e.getPlayer();

        // 플레이어 uuid
        UUID uuid = player.getUniqueId();

        Main.getMain().getPlayerDataStorage().createPlayerData(uuid); // 플레이어 데이터 파일 생성
        PlayerData playerData = Main.getMain().getPlayerDataStorage().loadPlayerData(uuid); // 플레이어 데이터 불러오기
        Main.getMain().getPlayerManager().createPlayer(playerData); // 플레이어 데이터 매니저에 저장
        Main.getMain().getPlayerStatManager().applyStats(player, playerData); // 플레이어 스텟 적용
  }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){
    // 플레이어 uuid
    UUID uuid = e.getPlayer().getUniqueId();
    
    // 플레이어 데이터 매니저에서 플레이어 데이터 가져오기
    PlayerData playerData = Main.getMain().getPlayerManager().getPlayerData(uuid);

    // 플레이어 데이터 저장 및 매니저에서 삭제
    Main.getMain().getPlayerDataStorage().savePlayerData(playerData);
    Main.getMain().getPlayerManager().removePlayer(uuid);
  }
}
