package me.elli0t43.testplugin.Commands;
import me.elli0t43.testplugin.TestPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Godmode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("TestPlugin.god")) {
                    if (p.isInvulnerable()) {
                        p.setInvulnerable(false);
                        p.sendMessage(ChatColor.RED + "God Mode Disabled!!");
                    } else {
                        p.setInvulnerable(true);
                        p.sendMessage(ChatColor.GREEN + "God Mode Enabled!!");
                    }
            }else{
                p.sendMessage(ChatColor.RED + "You don't have the permission to run this command!");
            }
        }
        return true;
    }

}