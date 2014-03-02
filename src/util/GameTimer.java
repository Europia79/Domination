/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.scheduler.BukkitRunnable;

/**
 *
 * @author Nikolai
 */
public class GameTimer extends BukkitRunnable {
    
    long startTime;
    InventoryOpenEvent event;
    int i = 0;
    
    public GameTimer(InventoryOpenEvent e) {
        startTime = System.nanoTime();
        event = e;
    }
    
    public long getCurrentTime() {
        return (System.nanoTime() / 1000000000);
    }
    
    public long getStartTime() {
        return (this.startTime / 1000000000);
    }
    
    public boolean hasFiveSecondsElapsed() {
        return ((getCurrentTime() - getStartTime() >= 5));
                
    }

    @Override
    public void run() {
        i = i + 1;
        Player p = (Player) event.getPlayer();
        p.sendMessage("" + i);
        if (i >= 5) {
            p.closeInventory();            
            p.sendMessage(ChatColor.LIGHT_PURPLE
                    + "You have captured this objective!");
            this.cancel();
        }
        
        
    }
    
}
