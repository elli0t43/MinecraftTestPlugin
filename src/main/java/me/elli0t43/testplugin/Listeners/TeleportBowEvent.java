package me.elli0t43.testplugin.Listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class TeleportBowEvent implements Listener{
    @EventHandler
    public void onBowShoot(ProjectileHitEvent e){
        if (e.getEntity() instanceof Arrow){
            Player p = (Player) e.getEntity().getShooter();
            Location location = e.getEntity().getLocation();


            p.playSound(p.getLocation(), Sound.AMBIENT_CAVE, 1.0F, 1.0F);
            p.teleport(location);

        }

    }

}
