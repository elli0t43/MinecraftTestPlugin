package me.elli0t43.testplugin.Commands;


import me.elli0t43.testplugin.TestPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ConfigTestCommand implements CommandExecutor {

    Plugin plugin = TestPlugin.getPlugin(TestPlugin.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (p.hasPermission("TestPlugin.conftest")){

                Player player = (Player) sender;
                String food = plugin.getConfig().getString("Food");
                int number = plugin.getConfig().getInt("Number");
                boolean boolean1 = plugin.getConfig().getBoolean("Boolean");
                String foodlist = plugin.getConfig().getStringList("FoodList").get(1);
                player.sendMessage(ChatColor.RED + food);
                player.sendMessage(ChatColor.GREEN + "" + number);
                player.sendMessage(ChatColor.AQUA + "" +  boolean1);
                player.sendMessage(ChatColor.YELLOW + "" + foodlist);

            }else{
                p.sendMessage(ChatColor.RED + "You don't have the persmission to run this command!");
            }
        }
        return true;
    }
}
