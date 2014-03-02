/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.battlecraft.Flags;

import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Nikolai (Europia79)
 * email Nikolai.Kalashnikov@hotmail.com
 * 
 */
public class Main extends JavaPlugin {
    
    @Override
    public void onEnable() {
        
        getServer().getPluginManager().registerEvents(new InventoryListener(this), this);
        //getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        
    }
    

}
