package com.aporia.command;

import com.aporia.Main;

import com.aporia.monster.MonsterData;

import org.bukkit.command.CommandExecutor;

import org.bukkit.Location;

import org.bukkit.entity.Player;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.EntityType;

public class SpawnMobCommand implements CommandExecutor {
  @Override
  public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
    
    if(!(sender instanceof Player player)){
        return true;
    }

    if(args.length < 1){
        player.sendMessage("사용법: /spawnmob <몬스터ID>");

        return true;
    }

    String monsterId = args[0];
    MonsterData data = Main.getMain().getMonsterManager().getMonsterData(monsterId);

    if(data == null){
        sender.sendMessage("존재하지 않는 몬스터입니다.");
        
        return true;
    }

    // 몬스터 스폰 로직 (예시로 플레이어 위치에 좀비를 스폰하도록 설정)
    Location location = player.getLocation();
    EntityType entityType = EntityType.ZOMBIE; // 예시로 좀비를 스폰하도록 설정


    LivingEntity entity = (LivingEntity) location.getWorld().spawnEntity(location, entityType);
    Main.getMain().getMonsterManager().setupMonster(entity, monsterId); // 몬스터 레벨 설정

    sender.sendMessage(data.getName() + "스폰 완료");

    return true;
  }
}
