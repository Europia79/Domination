package co.battlecraft.Flags.debug;

import org.bukkit.entity.Player;

/**
 *
 * @author Nikolai
 */
public class DebugOff implements DebugInterface {

    @Override
    public void log(String m) {
    }

    @Override
    public void messagePlayer(Player p, String m) {
    }
    
}
