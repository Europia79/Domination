/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.battlecraft.Flags;

import org.bukkit.Location;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import co.battlecraft.util.GameTimer;

/**
 *
 * @author Nikolai
 */
class Objectif {
    
    Plugin plugin;
    InventoryOpenEvent event;
    GameTimer timer;
    BukkitTask taskID;
    Location loc;
    
    public Objectif(Plugin instance, InventoryOpenEvent e) {
        
        this.plugin = instance;
        this.event = e;
        this.timer = new GameTimer(e);
        taskID = timer.runTaskTimer(plugin, 20L, 20L);
                               
        this.loc = e.getPlayer().getLocation();
    }
    
    public GameTimer getTimer() {
        return timer;
    }
    
    public BukkitTask getTask() {
        return taskID;
    }
    
}
