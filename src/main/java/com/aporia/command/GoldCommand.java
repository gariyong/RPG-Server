package com.aporia.command;

import com.aporia.Main;
import com.aporia.player.PlayerData;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class GoldCommand implements CommandExecutor {

    private static final String PERMISSION = "aporia.admin";

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        // 사용법: /gold <add|remove|set|check> <player> [amount]
        if (args.length < 1) {
            sender.sendMessage("사용법: /gold <add|remove|set|check> <player> [amount]");
            return true;
        }

        String sub = args[0].toLowerCase();

        // check는 본인 골드 확인용으로 별도 처리 (대상 플레이어 없이 본인 조회 가능)
        if (sub.equals("check")) {
            return handleCheck(sender, args);
        }

        // add/remove/set은 관리자 권한 필요
        if (!sender.hasPermission(PERMISSION)) {
            sender.sendMessage("이 명령어를 사용할 권한이 없습니다.");
            return true;
        }

        if (args.length < 3) {
            sender.sendMessage("사용법: /gold " + sub + " <player> <amount>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[1]);
        if (target == null) {
            sender.sendMessage("온라인 상태가 아니거나 존재하지 않는 플레이어입니다.");
            return true;
        }

        long amount;
        try {
            amount = Long.parseLong(args[2]);
        } catch (NumberFormatException e) {
            sender.sendMessage("금액은 숫자로 입력해야 합니다.");
            return true;
        }

        if (amount < 0) {
            sender.sendMessage("금액은 0 이상이어야 합니다.");
            return true;
        }

        UUID uuid = target.getUniqueId();
        PlayerData playerData = Main.getMain().getPlayerManager().getPlayerData(uuid);

        if (playerData == null) {
            sender.sendMessage("플레이어 데이터를 찾을 수 없습니다.");
            return true;
        }

        switch (sub) {
            case "add":
                playerData.addGold(amount);
                sender.sendMessage(target.getName() + "에게 " + amount + "G를 지급했습니다. (현재: " + playerData.getGold() + "G)");
                target.sendMessage(amount + "G를 지급받았습니다.");
                break;

            case "remove":
                if (!playerData.removeGold(amount)) {
                    sender.sendMessage(target.getName() + "의 골드가 부족하여 차감할 수 없습니다. (현재: " + playerData.getGold() + "G)");
                    return true;
                }
                sender.sendMessage(target.getName() + "에게서 " + amount + "G를 차감했습니다. (현재: " + playerData.getGold() + "G)");
                target.sendMessage(amount + "G가 차감되었습니다.");
                break;

            case "set":
                playerData.setGold(amount);
                sender.sendMessage(target.getName() + "의 골드를 " + amount + "G로 설정했습니다.");
                target.sendMessage("골드가 " + amount + "G로 설정되었습니다.");
                break;

            default:
                sender.sendMessage("사용법: /gold <add|remove|set|check> <player> [amount]");
                break;
        }

        return true;
    }

    // 본인 또는 타인의 골드 조회
    private boolean handleCheck(CommandSender sender, String[] args) {
        Player target;

        if (args.length >= 2) {
            // 다른 플레이어 조회는 관리자 권한 필요
            if (!sender.hasPermission(PERMISSION)) {
                sender.sendMessage("다른 플레이어의 골드를 조회할 권한이 없습니다.");
                return true;
            }

            target = Bukkit.getPlayer(args[1]);
            if (target == null) {
                sender.sendMessage("온라인 상태가 아니거나 존재하지 않는 플레이어입니다.");
                return true;
            }
        } else {
            if (!(sender instanceof Player)) {
                sender.sendMessage("콘솔에서는 대상을 지정해야 합니다. /gold check <player>");
                return true;
            }
            target = (Player) sender;
        }

        PlayerData playerData = Main.getMain().getPlayerManager().getPlayerData(target.getUniqueId());
        if (playerData == null) {
            sender.sendMessage("플레이어 데이터를 찾을 수 없습니다.");
            return true;
        }

        sender.sendMessage(target.getName() + "의 골드: " + playerData.getGold() + "G");
        return true;
    }
}