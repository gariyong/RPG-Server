package com.aporia.command;

import com.aporia.Main;
import com. aporia.player.PlayerData;

import org.bukkit.entity.Player;
import org.bukkit.command.*;

public class ExpCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        
        // 명령어 사용 주체가 플레이어인지 확인
        if(!(sender instanceof Player)){
            sender.sendMessage("콘솔에서는 사용할 수 없는 명령어입니다.");

            return true;
        }

        // 명령어 사용법 확인
        if(args.length != 2){
            sender.sendMessage("사용법: /exp add <경험치>");

            return true;
        }

        // 명령어가 "add"인지 확인
        if(!args[0].equalsIgnoreCase("add")){
            sender.sendMessage("사용법: /exp add <경험치>");

            return true;
        }

        // 경험치 양 파싱
        long amount;

        // 숫자로 입력했는지 확인
        try{
            amount = Long.parseLong(args[1]);
        }catch(Exception e){    
            sender.sendMessage("경험치는 숫자로 입력해야 합니다.");

            return true;
        }

        // 플레이어 데이터 가져온 후, 경험치 추가
        PlayerData playerData = Main.getMain().getPlayerManager().getPlayerData(((Player) sender).getUniqueId());
        Main.getMain().getLevelManager().addExp((Player) sender, playerData, amount);
        sender.sendMessage("경험치를 획득하였습니다.");

        return true;
    }
    
}
