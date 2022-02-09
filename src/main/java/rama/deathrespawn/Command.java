package rama.deathrespawn;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {

    private final DeathRespawn plugin;

    public Command(final DeathRespawn plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        FileConfiguration config = plugin.getConfig();
        if(args[0].equalsIgnoreCase("setspawn")){
            Player player = (Player) sender;

            World world = player.getWorld();
            String world_name = world.getName();
            double x = player.getLocation().getX();
            double y = player.getLocation().getY();
            double z = player.getLocation().getZ();
            float yaw = player.getLocation().getYaw();
            float pitch = player.getLocation().getPitch();

            config.set("spawn.x", x);
            config.set("spawn.y", y);
            config.set("spawn.z", z);
            config.set("spawn.world", world_name);
            config.set("spawn.yaw", yaw);
            config.set("spawn.pitch", pitch);
            plugin.saveConfig();

            sender.sendMessage("Has definido el nuevo spawn correctamente.");
        }
        return false;
    }
}
