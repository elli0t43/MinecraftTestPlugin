package me.elli0t43.testplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class tpBowCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("TestPlugin.fly")) {
                ItemStack tp_bow = new ItemStack(Material.BOW);
                tp_bow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
                ItemMeta meta = tp_bow.getItemMeta();
                meta.setDisplayName(ChatColor.DARK_PURPLE + "Teleport " + ChatColor.AQUA + "Bow");
                meta.setUnbreakable(true);
                ArrayList<String> lore = new ArrayList<>();
                lore.add(ChatColor.GOLD + "A bow that allows you to teleport");
                lore.add(ChatColor.MAGIC + "Something Special :)");
                meta.setLore(lore);
                tp_bow.setItemMeta(meta);

                if (args.length == 0) {
                    p.getInventory().addItem(tp_bow);
                    p.sendMessage(ChatColor.GREEN + "You now have TP Bow. Enjoy tp'ing around :D ");
                } else if (args.length > 0) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target instanceof Player) {
                        target.getInventory().addItem(tp_bow);
                        p.sendMessage(ChatColor.GREEN + "You now have TP Bow. Enjoy tp'ing around :D ");
                        sender.sendMessage( ChatColor.GREEN +"given a tp bow to " + ChatColor.YELLOW + target.getDisplayName());
                    } else {
                        sender.sendMessage(ChatColor.RED + args[0] + ", Player doesn't exist");
                    }
                }else{
                    sender.sendMessage(ChatColor.RED + "Please add a valid argument!");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "You don't have permission to run this command!!");
            }

//        } else if (sender instanceof ConsoleCommandSender) {
//            if (args.length > 0) {
//                Player target = Bukkit.getPlayerExact(args[0]);
//                if (target instanceof Player) {
//                    target.getInventory().addItem()
//                } else {
//                    sender.sendMessage(ChatColor.AQUA + args[0] + ", Player doesn't exist");
//                }
//            }else{
//                sender.sendMessage(ChatColor.RED + "Please add a valid argument!");
//            }

        } else {
            sender.sendMessage(ChatColor.RED + "Only a Player can run this command!");
        }
        return true;
    }
}
