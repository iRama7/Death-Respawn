package rama.deathrespawn;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeathRespawn extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new DeathEvent(this), this);
        this.getCommand("dr").setExecutor(new Command(this));
    }

    @Override
    public void onDisable() {

    }
}
