error id: file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/command/StatsCommand.java:_empty_/PlayerData#setLevel#
file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/command/StatsCommand.java
empty definition using pc, found symbol in pc: _empty_/PlayerData#setLevel#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 778
uri: file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/command/StatsCommand.java
text:
```scala
package com.aporia.command;

import org.bukkit.entity.Player;
import org.bukkit.command.*;
import com.aporia.Main;
import com.aporia.player.PlayerData;

public class StatsCommand implements CommandExecutor{
    @Override // 명령어 실행 시 호출되는 메소드
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // 명령어가 "스텟"인 경우에만 실행
        if(cmd.getName().equalsIgnoreCase("스텟")){
            // 명령어 실행 주체가 플레이어인지 확인
            if(sender instanceof Player){
                Player player = (Player) sender;
                player.sendMessage("스텟 명령어 실행됨");

                // 플레이어의 스텟 정보를 가져와서 출력
                PlayerData playerData = Main.getMain().getPlayerManager().getPlayerData(player.getUniqueId());
                playerData.setLe@@vel(123);
                playerData.setAttack(999);
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

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/PlayerData#setLevel#