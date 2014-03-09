package co.battlecraft.Flags;

import com.github.Europia79.debug.*;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Nikolai (Europia79)
 * email Nikolai.Kalashnikov@hotmail.com
 * 
 */
public class Main extends JavaPlugin {
    
    private static Main reference;
    public DebugInterface debug;
    
    @Override
    public void onEnable() {
        
        getServer().getPluginManager().registerEvents(new InventoryListener(this), this);
        //getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        debug = new DebugOn();
        Main.reference = this;
        
    }
    
    public static Main getSelf() {
        return Main.reference;
    }

}
