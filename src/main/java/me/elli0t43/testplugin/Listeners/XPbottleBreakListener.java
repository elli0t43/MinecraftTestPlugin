package me.elli0t43.testplugin.Listeners;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExpBottleEvent;

import javax.swing.text.html.parser.Entity;

public class XPbottleBreakListener implements Listener {

    @EventHandler
    public void onXPBottleBreak(ExpBottleEvent e){

        e.setShowEffect(false);
        e.setExperience(1000);




    }


}
