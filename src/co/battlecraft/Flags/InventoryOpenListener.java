/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.battlecraft.Flags;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;

/**
 *
 * @author Nikolai
 */
public class InventoryOpenListener implements Listener {
    
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
            long milli = System.currentTimeMillis();
            
            
        }
        
    }
    
}
