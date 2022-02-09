package rama.deathrespawn;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class DeathEvent implements Listener {

    private final DeathRespawn plugin;

    public DeathEvent(final DeathRespawn plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void DeathEvent(PlayerRespawnEvent e){
        FileConfiguration config = plugin.getConfig();
        String world_name = config.getString("spawn.world");

        assert world_name != null;
        World world = Bukkit.getWorld(world_name);
        double x = config.getDouble("spawn.x");
        double y = config.getDouble("spawn.y");
        double z = config.getDouble("spawn.z");
        double yaw = config.getDouble("spawn.yaw");
        double pitch = config.getDouble("spawn.pitch");

        Location Spawn = new Location(world,x,y,z, (float) yaw, (float) pitch);

        e.setRespawnLocation(Spawn);

    }
}
