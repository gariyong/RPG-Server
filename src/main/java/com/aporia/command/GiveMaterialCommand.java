package com.aporia.command;

import com.aporia.Main;
import com.aporia.item.MaterialData;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveMaterialCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            return true;
        }

        if(!(sender.hasPermission("aporia.admin"))){
            return true;
        }
        
        if (args.length < 2) {
            player.sendMessage(
                    "/givematerial <id> <amount>"
            );
            return true;
        }

        String id = args[0];
        int amount;
        try {
            amount = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            player.sendMessage("수량은 숫자여야 합니다.");
            return true;
        }

        MaterialData data =Main.getMain().getMaterialManager().getMaterialData(id);
        if (data == null) {
            player.sendMessage("존재하지 않는 재료입니다.");
            return true;
        }

        ItemStack item =Main.getMain().getCustomItemManager().createMaterial(data);
        item.setAmount(amount);
        player.getInventory().addItem(item);
        player.sendMessage(data.getName() + " x" + amount + " 지급 완료");

        return true;
    }
}