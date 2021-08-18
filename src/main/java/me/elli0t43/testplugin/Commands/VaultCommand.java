package me.elli0t43.testplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class VaultCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (p.hasPermission("TestPlugin.vault")){
                Inventory vault = Bukkit.createInventory(p, 9, ChatColor.AQUA + "Your Vault");
                ItemStack item1 = new ItemStack(Material.NETHERITE_SWORD, 1);
                item1.addUnsafeEnchantment(Enchantment.VANISHING_CURSE, 10000);
                ItemMeta meta = item1.getItemMeta();
                meta.setDisplayName(ChatColor.AQUA + "elli" + ChatColor.RED + "0" + ChatColor.AQUA + "t" + ChatColor.RED + "43");
                meta.setUnbreakable(true);
                ArrayList<String> lore = new ArrayList<>();
                lore.add(ChatColor.RED + "Something Pretty Interesting :)");
                lore.add(ChatColor.AQUA  + "Specially made for elli0t43");
                lore.add(ChatColor.DARK_PURPLE + "If you know, You know :)");
                meta.setLore(lore);
                item1.setItemMeta(meta);
                vault.setItem(2, item1);


                p.openInventory(vault);




            }else{
                sender.sendMessage(ChatColor.RED + "You don't have permission to run this command!!");
            }

        }else{
            sender.sendMessage(ChatColor.RED + "Only a Player can run this command!");
        }









        return true;
    }
}
