/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.battlecraft.Flags;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Nikolai (Europia79)
 * email Nikolai.Kalashnikov@hotmail.com
 * 
 */
public class Main extends JavaPlugin {
    int time;
    int taskID;
    
    @Override
    public void onEnable() {
        time = 10;
        getServer().getPluginManager().registerEvents(new InventoryOpenListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        
    }

    
    

}
