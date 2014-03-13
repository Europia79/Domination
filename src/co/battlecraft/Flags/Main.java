package co.battlecraft.Flags;

import co.battlecraft.util.Download;
import com.github.Europia79.debug.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
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
    public DebugInterface debug;
    public Map<String, Objectif> pmap;
    
    @Override
    public void onEnable() {
        
        Main.reference = this;
        initializeDebugger();
        debug = new DebugOn();
        getServer().getPluginManager().registerEvents(new InventoryListener(this), this);
        
        
    }
    
    public static Main getSelf() {
        return Main.reference;
    }
    
    public void initializeDebugger() {
        
        new File("lib" + File.separator).mkdir();
        new File("lib" + File.separator).setWritable(true);
  
        File f = new File("lib/debug.jar");
        if (!f.exists()) {
            String address = "http://rainbowcraft.sytes.net/download/code/debug/debug.jar";
            try {
                Download.install(address, "lib", "debug.jar");
            } catch (MalformedURLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.debug = new DebugOn();
        
    }
}
