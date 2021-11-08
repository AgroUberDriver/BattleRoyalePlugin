package me.agro.battleroyale.listeners;

import me.agro.battleroyale.managers.GameState;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import me.agro.battleroyale.managers.GameManager;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventsListener implements Listener {

    private GameManager gameManager;

    @EventHandler

    public void onHit(PlayerInteractEvent e) {
        Block block = e.getClickedBlock();
        Player p = e.getPlayer();


        if (e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {

            if (block.getType().equals(Material.CHEST)) {
                Location ChestLocation = e.getClickedBlock().getLocation();
                p.playSound(ChestLocation, Sound.ENTITY_ZOMBIE_BREAK_WOODEN_DOOR, 2, 1);
                ChestLocation.getBlock().setType(Material.AIR);


                World world = ChestLocation.getWorld();


            }
        }
    }

}
