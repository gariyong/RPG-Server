package com.aporia.player;

import java.util.HashMap;
import java.util.UUID;

public class PlayerManager {
    // 플레이어 데이터를 관리할 해쉬 맵
    private final HashMap<UUID, PlayerData> playerDataMap = new HashMap<>();
    
    // 플레이어 생성
    public void createPlayer(PlayerData playerData){
        playerDataMap.put(playerData.getUuid(), playerData);
    }

    // 플레이어 데이터 반환
    public PlayerData getPlayerData(UUID uuid){
        return playerDataMap.get(uuid);
    }

    // 플레이어 삭제
    public void removePlayer(UUID uuid){
        playerDataMap.remove(uuid);
    }
}
