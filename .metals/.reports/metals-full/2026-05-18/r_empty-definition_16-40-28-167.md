error id: file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/MyCommand.java:_empty_/Inventory#
file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/MyCommand.java
empty definition using pc, found symbol in pc: _empty_/Inventory#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 1945
uri: file:///C:/Users/happy/OneDrive/바탕%20화면/Server/RPG-Server/src/main/java/com/aporia/MyCommand.java
text:
```scala
package com.aporia;

import org.bukkit.command.CommandExecutor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;


public class MyCommand implements CommandExecutor{

    @Override // OnCommand의 파라미터에는 Command Sender, Command, label, args로 구성
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args){
        // CommandSender : 명령어 실행 주체, Command : 실행된 명령어 객체, label : 실제 사용된 명령어 또는 별칭, args : 명령어 뒤에 입력된 매개변수
        // /myCommand [args1] [args2]를 플레이어가 실행했다 가정
        // CommandSender >> player, Command >> 이 명령어가 실행하는 내용, label >> /뒤에 붙는 myCommand, args >> args1, args2
        // 반환값이 boolean인 이유 : 명령어 처리 결과를 bukkit 서버에 전달하기 위해서
        // true >> 명령어 성공적으로 처리되었음을 서버에 전달, false >> plugin.yml에 정의된 사용법이 자동으로 출력

        if(cmd.getName().equalsIgnoreCase("test")){ // 명령어 이름을 대소문자 구분없이 비교하여 test 명령어가 실행된 경우에만 if문 코드 실행
            if(sender instanceof Player){           // sender가 Player인지 확인
                    sender.sendMessage("플러그인 작동");

                    return false;
            }
            sender.sendMessage("====================" + "\r \n" 
            + "                 콘솔창에서 입력되었습니다." + "\r\n"
            + "                 플레이어가 치시기 바랍니다." + "\r\n"
            + "                 ====================");

            return false;
        }

        if(cmd.getName().equalsIgnoreCase("인벤토리")){
            if(sender instanceof Player){
                Player player = (Player) sender;
                
            }
        }

        return true;
    }

    public void openCustomInventory(Player player){
        @@Inventory customInventory = Bukkit.createInventory(player, 9, "커스텀 인벤토리");
        ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = diamondSword.getItemMeta();

        if(meta != null){
            meta.setDisplayName("test diamond sword");
        }
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/Inventory#