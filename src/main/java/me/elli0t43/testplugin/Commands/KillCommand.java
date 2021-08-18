package me.elli0t43.testplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class KillCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (p.hasPermission("TestPlugin.kill")){
                if (args.length > 0){
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target instanceof Player) {
                        target.setHealth(0.0);
                        target.sendMessage(ChatColor.RED + "Oops!! you got killed");
                        sender.sendMessage(ChatColor.YELLOW + target.getDisplayName() + ChatColor.RED + " got killed");
                    }else{
                        sender.sendMessage(ChatColor.AQUA + "" + args[0] + "" + ChatColor.RED + " doesn't exist!!");
                    }
                }else{
                    p.sendMessage(ChatColor.RED + "Please add a valid argument.");
                }
            }else{
                p.sendMessage(ChatColor.RED + "You don't have the persmission to run this command!");
            }
        }else if(sender instanceof ConsoleCommandSender){
            if (args.length > 0){
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target instanceof Player) {
                    target.setHealth(0.0);
                    target.sendMessage(ChatColor.RED + "Oops!! you got killed");
                    sender.sendMessage(ChatColor.YELLOW + target.getDisplayName() + ChatColor.RED + " got killed");
                }else{
                    sender.sendMessage(ChatColor.AQUA + "" + args[0] + "" + ChatColor.RED + " doesn't exist!!");
                }
            }else{
                sender.sendMessage(ChatColor.RED + "Please add a valid argument.");
            }
        }else{
            sender.sendMessage(ChatColor.RED + "You have to be a Admin or in Console to run this command!!");
        }
        return true;
    }
}
