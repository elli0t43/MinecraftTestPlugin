package me.elli0t43.testplugin.Commands;
import me.elli0t43.testplugin.TestPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class feedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (p.hasPermission("TestPlugin.feed")) {
                if (p.getFoodLevel() < 20.0) {
                    p.setFoodLevel(20);
                    p.sendMessage(ChatColor.GREEN + "Your hunger bar is now full");
                } else {
                    p.sendMessage(ChatColor.RED + "Hunger Bar is already full");
                }
            }else{
                p.sendMessage(ChatColor.RED + "You don't have the persmission to run this command!");
            }
        }
        return true;
    }
}
