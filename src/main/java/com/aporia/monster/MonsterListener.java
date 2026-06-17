package com.aporia.monster;

import com.aporia.Main;
import com.aporia.item.EquipmentData;
import com.aporia.player.PlayerData;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import org.bukkit.entity.LivingEntity;

public class MonsterListener implements Listener{
    @EventHandler // 몬스터가 죽었을 때 실행되는 메소드
    public void onMonsterKill(EntityDeathEvent e){
        // 몬스터 데이터 불러오기
        MonsterData monsterData = Main.getMain().getMonsterManager().getMonsterData((LivingEntity)e.getEntity());

        if(monsterData == null){
            return;
        }

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
        long exp = monsterData.getExp();
        Main.getMain().getLevelManager().addExp(killer, playerData, exp);

        // 드랍 처리

        for(DropData drop : monsterData.getDrops()){
            // 확률 계산
            double random = Math.random() * 100;

            if(random > drop.getChance()) continue;

            // 아이템 조회
            EquipmentData equipmentData = Main.getMain().getEquipmentManager().getEquipmentData(drop.getItemId());
            
            if(equipmentData == null){
                continue;
            }

            // 생성
            ItemStack item = Main.getMain().getCustomItemManager().createEquipment(equipmentData);

            // 드랍
            e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), item);
        }

        
        
        // 경험치 획득 메시지 출력
        killer.sendMessage(Component.text("경험치 획득! (" + exp + ")").color(NamedTextColor.GOLD));

        // 경험치 지급 후 정리
        Main.getMain().getMonsterManager().removeLastAttacker((LivingEntity)e.getEntity());
    }
}
