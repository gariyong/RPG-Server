package com.aporia.item;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerItemHeldEvent;

import com.aporia.Main;

import com.aporia.player.PlayerData;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class EquipmentListener implements Listener{
    @EventHandler
    public void onHeldChange(PlayerItemHeldEvent e){
        Player player = e.getPlayer();
        
        PlayerData playerData = Main.getMain().getPlayerManager().getPlayerData(player.getUniqueId());
        
        if(playerData == null){
            return;
        }

        // 다음 틱에 실행(아이템 변경 적용 후)
        player.getServer().getScheduler().runTask(Main.getMain(), 
            () -> {
                int finalAttack = Main.getMain().getEquipmentStatManager()
                .getFinalAttack(player, playerData);

                
                player.sendMessage(Component.text("현재 공격력: " +  finalAttack).color(NamedTextColor.AQUA));
            });
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if(!(e.getWhoClicked() instanceof Player player)){
            return;
        }

        Bukkit.getScheduler().runTask(Main.getMain(),
             () -> {
                PlayerData playerData = Main.getMain().getPlayerManager().getPlayerData(player.getUniqueId());

                if(playerData == null){
                    return;
                }

                int defense = Main.getMain().getEquipmentStatManager().getFinalDefense(player, playerData);

                player.sendMessage(Component.text("현재 방어력: " + defense).color(NamedTextColor.AQUA));
             }
            );
    }
}
