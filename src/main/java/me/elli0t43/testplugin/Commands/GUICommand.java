package me.elli0t43.testplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GUICommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof  Player){
            Player p = (Player) sender;
            Inventory gui = Bukkit.createInventory(p, 9, ChatColor.MAGIC + "XX" + ChatColor.AQUA + "Custom GUI" + ChatColor.MAGIC + "XX");

            ItemStack kill = new ItemStack(Material.TNT);
            ItemMeta kill_meta = kill.getItemMeta();
            kill_meta.setDisplayName(ChatColor.RED + "Kill");
            ArrayList<String> kill_lore = new ArrayList<>();
            kill_lore.add(ChatColor.RED + "Kill the Player");
            kill_lore.add(ChatColor.GOLD + "RIP YOU");
            kill_meta.setLore(kill_lore);
            kill.setItemMeta(kill_meta);

            ItemStack feed = new ItemStack(Material.BREAD);
            ItemMeta feed_meta = feed.getItemMeta();
            feed_meta.setDisplayName(ChatColor.DARK_PURPLE + "Feed");
            ArrayList<String> feed_lore = new ArrayList<>();
            feed_lore.add(ChatColor.AQUA + "Fills the hunger bar");
            feed_lore.add(ChatColor.BLUE + "Bon Ap'etite");
            feed_meta.setLore(feed_lore);
            feed.setItemMeta(feed_meta);


            ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
            ItemMeta sword_meta = sword.getItemMeta();
            sword_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Sword");
            ArrayList<String> sword_lore = new ArrayList<>();
            sword_lore.add(ChatColor.RED + "Give the player a sword");
            sword_lore.add(ChatColor.GOLD + "Happy PVP");
            sword_meta.setLore(sword_lore);
            sword.setItemMeta(sword_meta);

            ItemStack glass = new ItemStack(Material.GLASS_PANE);
            ItemStack glass1 = new ItemStack(Material.GLASS_PANE);
            ItemStack glass2 = new ItemStack(Material.GLASS_PANE);
            ItemStack glass3 = new ItemStack(Material.GLASS_PANE);
            ItemStack glass4 = new ItemStack(Material.GLASS_PANE);
            ItemStack glass5 = new ItemStack(Material.GLASS_PANE);



            ItemStack[] menuitems = {kill, glass, glass1, glass4, feed, glass2, glass3, glass5, sword};
            gui.setContents(menuitems);
            p.openInventory(gui);
        }
        return true;
    }
}
