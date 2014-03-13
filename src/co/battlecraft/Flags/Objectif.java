/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.battlecraft.Flags;

import org.bukkit.Location;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.scheduler.BukkitTask;
import co.battlecraft.Flags.util.GameTimer;
import org.bukkit.Bukkit;

/**
 *
 * @author Nikolai
 */
public class Objectif {
    
    Main plugin;
    InventoryOpenEvent event;
    GameTimer timer;
    BukkitTask taskID;
    Location BEACON_LOCATION;
    int duration;
    
    public Objectif(InventoryOpenEvent e) {
        
        this.plugin = (Main) Bukkit.getServer().getPluginManager().getPlugin("BattlecraftFlags");
        this.event = e;
        // event.getPlayer().closeInventory();
        this.BEACON_LOCATION = e.getPlayer().getLocation();
        this.timer = new GameTimer(this);
        taskID = timer.runTaskTimer(plugin, 20L, 20L);

    }
    
    public GameTimer getTimer() {
        return timer;
    }
    
    public BukkitTask getTask() {
        return taskID;
    }
    
    public InventoryOpenEvent getEvent() {
        return this.event;
    }
    
    public Location getBeaconLocation() {
        return this.BEACON_LOCATION;
    }
    
    public long getDuration() {
        return this.duration;
    }
    
}
