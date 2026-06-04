package com.aporia.combat;

import com.aporia.Main;
import com.aporia.player.FinalPlayerStats;
import com.aporia.player.PlayerData;

import com.aporia.monster.MonsterData;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){

        // 플레이어 공격
        if(e.getDamager() instanceof Player player){
            handlePlayerAttack(player, e);
        }

        // 몬스터 공격
        else if(e.getDamager() instanceof LivingEntity monster && e.getEntity() instanceof Player player){
            handleMonsterAttack(monster, player, e);
        }
    }

    // 플레이어 공격 메서드
    private void handlePlayerAttack(Player player, EntityDamageByEntityEvent e){
        // 피해 대상
        Entity damaged = e.getEntity();

        if(!(damaged instanceof LivingEntity livingEntity)){
            return;
        }
        MonsterData data = Main.getMain().getMonsterManager().getMonsterData(livingEntity);

        if(data == null){
            return;
        }

        // PlayerData 가져오기
        PlayerData playerData = Main.getMain().getPlayerManager().getPlayerData(player.getUniqueId());

        // 스텟 가져오기
        FinalPlayerStats stats = Main.getMain().getEquipmentStatManager().calculateStats(player, playerData);
        
        // Monster 방어력 가져오기
        int monsterDefense = data.getDefense();

        // 플레이어 공격력 가져오기
        int playerAttack = stats.getAttack();

        // 데미지 계산
        DamageResult result = Main.getMain().getDamageCalculator().calculatePlayerDamage(playerAttack, monsterDefense, stats.getCritChance(), stats.getCritDamage());
        double damage = result.getDamage();

        // 최대 체력 Attribute 가져오기
        AttributeInstance attribute = livingEntity.getAttribute(Attribute.MAX_HEALTH);

        if(attribute == null){
            return;
        }

        // 현재 체력
        double currentHealth = livingEntity.getHealth();

        // 최대 체력
        double maxHealth = attribute.getValue();

        // 마지막 공격자
        Main.getMain().getMonsterManager().setLastAttacker(livingEntity, player);

        // 다음 체력 계산
        double nextHealth = Math.max(0, currentHealth - damage);

        // 기본 마인크래프트 데미지 취소
        e.setCancelled(true);

        // 직접 체력 설정
        livingEntity.setHealth(nextHealth);

        // 체력 출력
        player.sendMessage( Component.text("체력: " + (int)Math.ceil(nextHealth) + " / " 
                            + (int)Math.ceil(maxHealth)).color(NamedTextColor.RED));

        // 치명타 적용 여부 출력
        if(result.isCritical()){
            player.sendMessage(Component.text("치명타!").color(NamedTextColor.GOLD));
        }

        // 데미지 출력
        player.sendMessage(Component.text(damage + "의 피해를 입혔습니다.").color(NamedTextColor.YELLOW));
    }

    // 몬스터 공격 메서드
    private void handleMonsterAttack(LivingEntity monster, Player player, EntityDamageByEntityEvent e){
        // 몬스터 데이터 불러오기
        MonsterData monsterData = Main.getMain().getMonsterManager().getMonsterData(monster);

        if(monster == null){
            return;
        }

        // 몬스터 공격력 가져오기
        int monsterAttack = monsterData.getAttack();

        // 플레이어 데이터 가져오기
        PlayerData playerData = Main.getMain().getPlayerManager().getPlayerData(player.getUniqueId());

        // 플레이어 스텟 가져오기
        FinalPlayerStats stats = Main.getMain().getEquipmentStatManager().calculateStats(player, playerData);

        // 플레이어 방어력 가져오기
        int playerDefense = stats.getDefense();

        // 데미지 계산
        double damage = Main.getMain().getDamageCalculator().calculateMonsterDamage(monsterAttack, playerDefense);
        
        // 데미지 적용
        e.setDamage(damage);

        // 메세지
        player.sendMessage("몬스터에게 " + damage + "데미지를 입었습니다.");
    }
}