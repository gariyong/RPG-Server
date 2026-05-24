package com.aporia.command;

import com.aporia.Main;

import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.EntityType;

public class SpawnMobCommand implements CommandExecutor {
  @Override
  public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
    
    if(!(sender instanceof Player player)){
        return true;
    }

    if(args.length < 1){
        player.sendMessage("사용법: /spawnmob <레벨>");

        return true;
    }

    int level;

    try{
        level = Integer.parseInt(args[0]);
    }catch(NumberFormatException e){
        player.sendMessage("레벨은 숫자로 입력해야 합니다.");

        return true;
    }

    // 몬스터 스폰 로직 (예시로 플레이어 위치에 좀비를 스폰하도록 설정)
    Location location = player.getLocation();
    EntityType entityType = EntityType.ZOMBIE; // 예시로 좀비를 스폰하도록 설정


    LivingEntity entity = (LivingEntity) location.getWorld().spawnEntity(location, entityType);
    Main.getMain().getMonsterManager().setupMonster(entity, level); // 몬스터 레벨 설정

    sender.sendMessage("레벨 " + level + " 몬스터가 스폰되었습니다.");

    return true;
  }
}
