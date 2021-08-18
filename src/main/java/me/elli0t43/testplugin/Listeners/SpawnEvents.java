package me.elli0t43.testplugin.Listeners;

import me.elli0t43.testplugin.TestPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;


public class SpawnEvents implements Listener {
    TestPlugin plugin;

    public SpawnEvents(TestPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onSpawnEvent(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if (plugin.getConfig().getBoolean("give-tpbow-on-spawn")){
            plugin.givePlayerBow(p);

        }

    }

}
