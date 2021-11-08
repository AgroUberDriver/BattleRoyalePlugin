package me.agro.battleroyale.tasks;

import me.agro.battleroyale.managers.GameManager;
import me.agro.battleroyale.managers.GameState;
import me.agro.battleroyale.util.Chat;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class GameStartCountdown extends BukkitRunnable {

    private GameManager gameManager;


    public GameStartCountdown(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    private int timeLeft = 30;

    @Override
    public void run() {
        timeLeft--;
        if(timeLeft <= 0) {
            cancel();
            gameManager.setGameState(GameState.ACTIVE);
            return;
        }

        Bukkit.broadcastMessage(Chat.color("&eThe Game will begin in &a" + timeLeft + " seconds!"));
    }
}
