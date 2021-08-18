package me.elli0t43.testplugin;

import me.elli0t43.testplugin.Commands.*;
import me.elli0t43.testplugin.Listeners.*;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;


public final class TestPlugin extends JavaPlugin implements Listener {


    @Override
    public void onEnable() { // the on start or whenver the plugin starts this function runs
        // Plugin startup logic
        System.out.println("/-----------------------------\\");
        System.out.println("/-------THE PLUGIN v1.0-------\\");
        System.out.println("/-----------------------------\\");
        System.out.println("/-----------------------------\\");
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this); // we have to register the listener or the event, if we don't do that it won't work simply
        getServer().getPluginManager().registerEvents(new XPbottleBreakListener(), this);
        getServer().getPluginManager().registerEvents(new ShearSheepListener(), this);
        getServer().getPluginManager().registerEvents(new JoinAndLeavePlugin(), this);
        getServer().getPluginManager().registerEvents(new TeleportBowEvent(), this);
        getServer().getPluginManager().registerEvents(new SpawnEvents(this), this);
        getServer().getPluginManager().registerEvents(new MoveEvent(), this);
        getServer().getPluginManager().registerEvents(new GUIEvent(), this);



        // YOU CAN DO THIS ALSO TO REGISTER A COMMAND. AND THIS IS MAINLY AND WIDELY USED!!!
        getCommand("god").setExecutor(new Godmode());
        getCommand("feed").setExecutor(new feedCommand());
        getCommand("conftest").setExecutor(new ConfigTestCommand());
        getCommand("sendword").setExecutor(new SendWord());
        getCommand("kill").setExecutor(new KillCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("vault").setExecutor(new VaultCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("nfly").setExecutor(new nflyCommand());
        getCommand("tpbow").setExecutor(new tpBowCommand());
        getCommand("gui").setExecutor(new GUICommand());


    }
//    A way to create commands inside the main class, tho its not a good practice
//    @Override
//    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
//        if (command.getName().equalsIgnoreCase("die")){
//            if(sender instanceof Player p){ // that end p is available only in java 16
//                // Player p = (Player) sender; // older java options,
//                p.setHealth(0.0);
//                p.sendMessage("You died LOL");
//
//            }
//
//        }
//
//        return true;
//    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("conft")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                String food = getConfig().getString("Food");
                int number = getConfig().getInt("Number");
                boolean boolean1 = getConfig().getBoolean("Boolean");
                String foodlist = getConfig().getStringList("FoodList").get(1);
                p.sendMessage(ChatColor.RED + food);
                p.sendMessage(ChatColor.GREEN + "" + number);
                p.sendMessage(ChatColor.AQUA + "" +  boolean1);
                p.sendMessage(ChatColor.YELLOW + "" + foodlist);


            }
        }

        return true;
    }

    @EventHandler // this creates an event listener or a listener whatever you wanna call it
    public void onPlayerJoin(PlayerJoinEvent event) { // this is kinda the main method for the event with the PlayerJoinEvent taken from bukkit
        System.out.println("A player joined the goddamn server lmao"); // the main code. right now its just a sout
        event.setJoinMessage("Helllllo :) ");
        event.getPlayer();

    }

    @EventHandler
    public void onPlayerBedLeave(PlayerBedLeaveEvent event) {
        Player playerName = event.getPlayer();
        playerName.sendMessage("You motherfucker left the fucking bed!!");
        playerName.setHealthScale(20);
        playerName.setHealth(5);

    }

    public void givePlayerBow(Player p){
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
        p.getInventory().addItem(tp_bow);
    }

}