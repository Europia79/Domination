package co.battlecraft.Flags;

import co.battlecraft.Flags.debug.*;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Nikolai (Europia79)
 * email Nikolai.Kalashnikov@hotmail.com
 * 
 */
public class Main extends JavaPlugin {
    
    private static Main reference;
    public Map<String, Objectif> pmap;
    public DebugInterface debug;
    
    @Override
    public void onEnable() {
        
        Main.reference = this;
        debug = new DebugOn();

        getServer().getPluginManager().registerEvents(new InventoryListener(this), this);
        
        
    }
    
    @Override
    public void onDisable() {
        org.bukkit.event.HandlerList.unregisterAll();

    }
    
    public static Main getSelf() {
        return Main.reference;
    }
    

}
