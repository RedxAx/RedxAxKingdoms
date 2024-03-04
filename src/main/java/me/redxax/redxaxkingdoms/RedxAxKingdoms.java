package me.redxax.redxaxkingdoms;

import me.redxax.redxaxkingdoms.roles.SlimesRole;
import me.redxax.redxaxkingdoms.roles.ThundersRole;
import me.redxax.redxaxkingdoms.roles.WitchesRole;
import me.redxax.redxaxkingdoms.roles.ZombiesRole;

import org.bukkit.plugin.java.JavaPlugin;

public class RedxAxKingdoms extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("RedxAxKingdoms has been enabled!");
        getServer().getPluginManager().registerEvents(new ZombiesRole(), this);
        getServer().getPluginManager().registerEvents(new SlimesRole(), this);
        getServer().getPluginManager().registerEvents(new ThundersRole(), this);
        getServer().getPluginManager().registerEvents(new WitchesRole(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("RedxAxKingdoms has been disabled!");
    }
}