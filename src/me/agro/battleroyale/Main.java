package me.agro.battleroyale;

import me.agro.battleroyale.listeners.Command;
import me.agro.battleroyale.listeners.EventsListener;
import me.agro.battleroyale.managers.GameManager;
import org.bukkit.Bukkit;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Main extends JavaPlugin {


    private GameManager gameManager;


    @Override
    public void onEnable() {


        Bukkit.getPluginManager().registerEvents(new EventsListener(), this);

        this.gameManager = new GameManager(this);


        getCommand("start").setExecutor(new Command(gameManager));

        File configFile = new File(this.getDataFolder() + "/config.yml");
        if(!configFile.exists())
        {
            this.saveDefaultConfig();
        }


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
