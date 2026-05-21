package com.aporia.command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.command.*;
import com.aporia.Main;
import com.aporia.player.PlayerData;

public class StatsCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // 명령어가 "스텟"인 경우에만 실행
        if(cmd.getName().equalsIgnoreCase("스텟")){
            // 명령어 실행 주체가 플레이어인지 확인
            if(sender instanceof Player){
                Player player = (Player) sender;
                player.sendMessage("스텟 명령어 실행됨");

                // 플레이어의 스텟 정보를 가져와서 출력
                PlayerData playerData = Main.getMain().getPlayerManager().getPlayerData(player.getUniqueId());
                player.sendMessage("레벨: " + playerData.getLevel());
                player.sendMessage("경험치: " + playerData.getExp());
                player.sendMessage("공격력: " + playerData.getAttack());

                return true;
            }
            sender.sendMessage("콘솔에서는 사용할 수 없는 명령어입니다.");
            return false;   
        }

        return false;
    }
}
