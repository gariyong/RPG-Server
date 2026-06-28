package com.aporia.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.aporia.Main;

public class CraftCommand implements CommandExecutor{
    @Override 
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(!(sender instanceof Player player)){
            return true;
        }

        if(!(sender.hasPermission("aporia.admin"))){
            return true;
        }

        if(args.length < 1){
            player.sendMessage("/craft <recipeId>");

            return true;
        }

        String recipeId = args[0];
        boolean success = Main.getMain().getCraftManager().craft(player, recipeId);

        if(success){
            player.sendMessage("제작 성공!");
        }else{
            player.sendMessage("제작 실패!");
        }

        return true;
    }
}
