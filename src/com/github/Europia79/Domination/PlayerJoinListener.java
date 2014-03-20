/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.battlecraft.Flags;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 *
 * @author Nikolai
 */
public class PlayerJoinListener implements Listener {
    private Main plugin;
    private int taskID;
    private int time;
    
    
    public PlayerJoinListener(Main instance) {
        this.plugin = instance;
        
    }
    
    public void onPlayerJoin(PlayerJoinEvent e) {
        
        time = 10;
        Player p = (Player) e.getPlayer();
        p.sendMessage("Welcome to Battlecraft !");
        
        
        taskID = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this.plugin, new Runnable()                
        {

            @Override
            public void run() {
                Bukkit.broadcastMessage(Integer.toString(time));
                plugin.getServer().broadcastMessage("" + time);
                //p.sendMessage("" + time);
                if (time < 0)
                {
                    PlayerJoinListener.this.cancel();
                    plugin.getServer().getScheduler().cancelTask(taskID); 
                }
                time = time - 1;
            }
           
        }, 0, 20L);

        

    }

    private void cancel() {
        Bukkit.getScheduler().cancelTask(taskID);
    }
    
    
}
