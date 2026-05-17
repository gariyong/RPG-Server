package com.aporia;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("MyPlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin Disabled!");
    }
}
