package com.aporia.monster;

import com.aporia.Main;
import com.aporia.player.PlayerData;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.entity.Player;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

public class MonsterListener implements Listener{
    @EventHandler // 몬스터가 죽었을 때 실행되는 메소드
    public void onMonsterKill(EntityDeathEvent e){
        //  몬스터를 죽인 플레이어 가져오기
        Player killer = Main.getMain().getMonsterManager().getLastAttacker((LivingEntity)e.getEntity());

        System.out.println("EntityDeathEvent 발생");
        System.out.println("killer = " + killer);

        // 몬스터를 죽인 플레이어가 없으면 종료
        if(killer == null){
            return;
        }
        
         // 플레이어 데이터 불러오기
        PlayerData playerData = Main.getMain().getPlayerManager().getPlayerData(killer.getUniqueId());

        // 경험치 추가
        long exp = getMonsterExp(e.getEntityType());
        Main.getMain().getLevelManager().addExp(killer, playerData, exp);

        // 경험치 획득 메시지 출력
        killer.sendMessage(Component.text("경험치 획득! (" + exp + ")").color(NamedTextColor.GOLD));

        // 경험치 지급 후 정리
        Main.getMain().getMonsterManager().removeLastAttacker((LivingEntity)e.getEntity());
    }

    // 몬스터 종류에 따른 경험치 양 반환 메소드
    private long getMonsterExp(EntityType type){

        // 몬스터 종류에 따라 경험치 양 반환
        switch(type){
            case ZOMBIE:
                return 50;
            case SKELETON:
                return 70;
            case CREEPER:
                return 100;
            default:
                return 10;
        }
    }
}
