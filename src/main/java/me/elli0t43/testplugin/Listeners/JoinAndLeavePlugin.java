package me.elli0t43.testplugin.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinAndLeavePlugin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();

        if (player.hasPlayedBefore()){
            player.sendMessage(ChatColor.GREEN + player.getDisplayName() + ChatColor.BLUE + ", Welcome back to the server, Hope you have a good day");
        }else{
            player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + player.getDisplayName() + ChatColor.BLUE + ", Joined For the first time. Welcome :D");
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        Player player = e.getPlayer();
        player.sendMessage(ChatColor.RED + player.getDisplayName() + ChatColor.BLUE + "Has left the server!");
    }
}
