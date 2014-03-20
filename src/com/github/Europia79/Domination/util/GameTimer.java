package co.battlecraft.Flags.util;

import co.battlecraft.Flags.Main;
import co.battlecraft.Flags.Objectif;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.scheduler.BukkitRunnable;

/**
 *
 * @author Nikolai
 */
public class GameTimer extends BukkitRunnable {
    
    long startTime;
    long duration;
    Main plugin;
    Objectif objectif;
    InventoryOpenEvent event;
    Player player;
    Location BEACON_LOCATION;
    int i = 0;
    
    public GameTimer(Objectif o) {
        startTime = System.nanoTime();
        this.plugin = (Main) Bukkit.getServer().getPluginManager().getPlugin("BattlecraftFlags");
        this.event = o.getEvent();
        this.player = (Player) event.getPlayer();
        player.closeInventory();
        this.BEACON_LOCATION = o.getBeaconLocation();
        this.duration = 10;
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
        if (player.getLocation().distanceSquared(BEACON_LOCATION) > 64) {
            player.sendMessage(ChatColor.RED + "You have failed to capture the objective"
                    + "because you moved too far away");
            if (plugin.pmap.containsKey(player.getName())) {
                plugin.pmap.remove(player.getName());
            }
            this.cancel();
            return;         
        }
        player.sendMessage("" + i);
        if (i >= 7) {          
            player.sendMessage(ChatColor.LIGHT_PURPLE
                    + "You have captured this objective!");
            this.cancel();
        }
        
        
    }
    
}
