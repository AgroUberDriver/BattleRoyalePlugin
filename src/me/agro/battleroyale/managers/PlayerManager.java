package me.agro.battleroyale.managers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Random;

public class PlayerManager {

    private GameManager gameManager;


    public PlayerManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }


    public void scatterPlayers() {

        Random r = new Random();
        int Low = 50;
        int High = 200;


        for(Player p : Bukkit.getOnlinePlayers()) {
            World world = p.getWorld();
            int x = r.nextInt(High-Low) + Low;
            int z = r.nextInt(High-Low) + Low;
            int y = world.getHighestBlockYAt(x,z);

            Location location = new Location(p.getWorld(), x,y,z);
            p.teleport(location);

        }

    }
}
