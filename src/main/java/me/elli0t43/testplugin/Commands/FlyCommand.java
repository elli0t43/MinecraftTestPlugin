package me.elli0t43.testplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import java.util.ArrayList;

public class FlyCommand implements CommandExecutor {
    private ArrayList<Player> list_of_players = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("TestPlugin.fly")) {
                if (args.length == 0) {
                    if (list_of_players.contains(p)){
                        list_of_players.remove(p);
                        p.setAllowFlight(false);
                        p.sendMessage(ChatColor.RED + "Fly Disabled");
                    }else if (!list_of_players.contains(p)){
                        list_of_players.add(p);
                        p.setAllowFlight(true);
                        p.sendMessage(ChatColor.GREEN + "Fly Enabled");
                    }
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target instanceof Player) {
                        if (list_of_players.contains(target)){
                            list_of_players.remove(target);
                            target.setAllowFlight(false);
                            target.sendMessage(ChatColor.RED + "Fly Disabled");
                            sender.sendMessage(ChatColor.RED + " Fly Disabled for " + ChatColor.AQUA + args[0]);
                        }else if (!list_of_players.contains(target)){
                            list_of_players.add(target);
                            target.setAllowFlight(true);
                            target.sendMessage(ChatColor.GREEN + "Fly Enabled");
                            sender.sendMessage(ChatColor.GREEN + " Fly Enabled for " + ChatColor.AQUA + args[0]);
                        }
                    } else {
                        sender.sendMessage(ChatColor.AQUA + args[0] + ", Player doesn't exist");
                    }
                }else{
                    sender.sendMessage(ChatColor.RED + "Please add a valid argument!");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "You don't have permission to run this command!!");
            }
        } else if (sender instanceof ConsoleCommandSender) {
                if (args.length == 1) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target instanceof Player) {
                        if (list_of_players.contains(target)){
                            list_of_players.remove(target);
                            target.setAllowFlight(false);
                            target.sendMessage(ChatColor.RED + "Fly Disabled");
                            sender.sendMessage(ChatColor.RED + " Fly Disabled for " + ChatColor.AQUA + args[0]);
                        }else if (!list_of_players.contains(target)){
                            list_of_players.add(target);
                            target.setAllowFlight(true);
                            target.sendMessage(ChatColor.GREEN + "Fly Enabled");
                            sender.sendMessage(ChatColor.GREEN + " Fly Enabled for " + ChatColor.AQUA + args[0]);
                        }
                    } else {
                        sender.sendMessage(ChatColor.AQUA + args[0] + ", Player doesn't exist");
                    }
                }else{
                    sender.sendMessage(ChatColor.RED + "Please add a valid argument!");
                }
        } else {
            sender.sendMessage(ChatColor.RED + "Only a Player can run this command!");
        }
        return true;
    }
}