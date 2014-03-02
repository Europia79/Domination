/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.battlecraft.Flags;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

/**
 *
 * @author Nikolai
 */
public class InventoryListener implements Listener {
    
    Plugin plugin;
    Map<String, Objectif> pmap;
    Objectif objectif;
    BukkitTask task;
    
    public InventoryListener(Plugin instance) {
        
        this.plugin = instance;
        this.pmap = new HashMap<String, Objectif>();
                
    }
    
    @EventHandler (priority = EventPriority.NORMAL)
    public void onInventoryOpen(InventoryOpenEvent e) {
        
        if (e.getInventory().getType() == InventoryType.BEACON) {
            Player player = (Player) e.getPlayer();
            player.sendMessage(ChatColor.GRAY
                    + "You are about to capture the objective at ");
            player.sendMessage(ChatColor.GRAY
                    + "X = " + ChatColor.YELLOW + ((int) player.getLocation().getX()) + " " + ChatColor.GRAY
                    + "Y = " + ChatColor.YELLOW + ((int) player.getLocation().getY()) + " " + ChatColor.GRAY
                    + "Z = " + ChatColor.YELLOW + ((int) player.getLocation().getZ()) + " " + ChatColor.GRAY
                    );
            
            pmap.put(player.getName(), new Objectif(plugin, e) );              
            
        }

    }
    
    @EventHandler (priority = EventPriority.NORMAL)
    public void onInventoryClose(InventoryCloseEvent e) {
        if (e.getInventory().getType() == InventoryType.BEACON) {
            if (pmap.containsKey(e.getPlayer().getName()) ) {
                //if (pmap.get(e.getPlayer()).getTimer().
                //
                objectif = pmap.get(e.getPlayer());
                task = objectif.getTask();
                task.cancel();
                pmap.remove(e.getPlayer().getName());
                
            }
        }

        
    }

}
