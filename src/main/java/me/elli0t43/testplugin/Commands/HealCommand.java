package me.elli0t43.testplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("TestPlugin.heal")) {
                if (args.length == 0) {
                    p.setHealth(20.0);
                    sender.sendMessage(ChatColor.GREEN + "You have been healed!!");
                } else if (args.length > 0) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target instanceof Player){
                        target.setHealth(20.0);
                        target.sendMessage(ChatColor.GREEN + "You have been Healed!!");
                        sender.sendMessage(ChatColor.AQUA + target.getDisplayName() + ChatColor.GREEN + " got Healed");
                    }else{
                        sender.sendMessage(ChatColor.AQUA + ""  + args[0] + "" + ChatColor.RED + " doesn't exist!!");
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "Please add a valid argument");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "You don't have permission to run this command");
            }
        } else if (sender instanceof ConsoleCommandSender) {
            if (args.length > 0) {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target instanceof Player){
                    target.setHealth(20.0);
                    target.sendMessage(ChatColor.GREEN + "You have been Healed!!");
                    sender.sendMessage(ChatColor.AQUA + target.getDisplayName() + ChatColor.GREEN + " got Healed");
                }else{
                    sender.sendMessage(ChatColor.AQUA + "" + args[0] + "" + ChatColor.RED + " doesn't exist!!");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Please add a valid argument");
            }
        }
    return true;
    }

}