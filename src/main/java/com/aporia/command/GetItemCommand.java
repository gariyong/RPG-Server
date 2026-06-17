package com.aporia.command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;

import org.bukkit.inventory.ItemStack;

import com.aporia.Main;
import com.aporia.item.EquipmentData;

public class GetItemCommand implements CommandExecutor{
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
    if(!(sender instanceof Player player)){
        return true;
    }

     // 아이템 ID 입력 확인
    if (args.length < 1) {
        player.sendMessage("/getitem <itemId>");

        return true;
    }
    
    // 장비 데이터 가져오기
    String itemId = args[0];
    EquipmentData equipmentData = Main.getMain().getEquipmentManager().getEquipmentData(itemId);

    if(equipmentData == null){
        player.sendMessage("존재하지 않는 아이템입니다.");
        
        return true;
    }

    // 장비 생성
    ItemStack itemStack = Main.getMain().getCustomItemManager().createEquipment(equipmentData);

    // 지급
    player.getInventory().addItem(itemStack);
    player.sendMessage(equipmentData.getName() + "아이템 추가 완료");    

    return true;
  }
}
