package org.github.shulkmenot;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.github.shulkmenot.Listener.ShulkMachine;

public final class ShulkMenot extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("[Shulk] Plugin load.");
        Bukkit.getPluginManager().registerEvents(new ShulkMachine(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
