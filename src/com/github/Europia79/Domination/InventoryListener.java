package co.battlecraft.Flags;

import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;

/**
 *
 * @author Nikolai
 */
public class InventoryListener implements Listener {
    
    Main plugin;
    
    public InventoryListener(Main instance) {
        
        this.plugin = (Main) Bukkit.getServer().getPluginManager().getPlugin("BattlecraftFlags");
        plugin.pmap = new HashMap<String, Objectif>();
                
    }
    
    @EventHandler (priority = EventPriority.NORMAL)
    public void onInventoryOpen(InventoryOpenEvent e) {
        
        if (e.getInventory().getType() == InventoryType.BEACON) {
            Player player = (Player) e.getPlayer();
            // player.closeInventory();
            player.sendMessage(ChatColor.GRAY
                    + "You are about to capture the objective at ");
            player.sendMessage(ChatColor.GRAY
                    + "X = " + ChatColor.YELLOW + ((int) player.getLocation().getX()) + " " + ChatColor.GRAY
                    + "Y = " + ChatColor.YELLOW + ((int) player.getLocation().getY()) + " " + ChatColor.GRAY
                    + "Z = " + ChatColor.YELLOW + ((int) player.getLocation().getZ()) + " " + ChatColor.GRAY
                    );
            
            plugin.pmap.put(player.getName(), new Objectif(e) );
            plugin.debug.messagePlayer(player, ChatColor.LIGHT_PURPLE + "This is a debugging message");
            e.setCancelled(true);
        }

    }
    
    @EventHandler (priority = EventPriority.NORMAL)
    public void onInventoryClose(InventoryCloseEvent e) {
       /* if (e.getInventory().getType() == InventoryType.BEACON) {
            if (pmap.containsKey(e.getPlayer().getName()) ) {
                //if (pmap.get(e.getPlayer()).getTimer().
                pmap.get(e.getPlayer().getName()).getTask().cancel();
                pmap.remove(e.getPlayer().getName());
               
            } 
        } */

        
    }

}
