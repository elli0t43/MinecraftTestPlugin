package me.elli0t43.testplugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SendWord implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (p.hasPermission("TestPlugin.sendword")){
                if (args.length > 0){
                    if (args[0].equalsIgnoreCase("fuckoff")){
                        p.sendMessage(ChatColor.LIGHT_PURPLE + args[0]);
                    }else if (args[0].equalsIgnoreCase("valhalla")){
                        p.sendMessage(ChatColor.AQUA + args[0]);
                    }else {
                        p.sendMessage(ChatColor.RED + "Please add a valid argument.");
                    }
                }else{
                    p.sendMessage(ChatColor.RED + "Please add a valid argument.");
                }

            }else{
                p.sendMessage(ChatColor.RED + "You don't have the persmission to run this command!");
            }


        }



        return true;
    }
}
