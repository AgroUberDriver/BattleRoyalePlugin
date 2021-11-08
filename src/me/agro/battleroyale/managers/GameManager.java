package me.agro.battleroyale.managers;

import me.agro.battleroyale.Main;
import me.agro.battleroyale.listeners.EventsListener;
import me.agro.battleroyale.tasks.GameStartCountdown;
import org.bukkit.Bukkit;
import me.agro.battleroyale.listeners.Command;

public class GameManager {

    private final Main plugin;
    private PlayerManager playerManager;

    private GameStartCountdown gameStartCountdown;


    private Command commandManager;

    private GameState gameState = GameState.WAITING;

    public GameManager(Main plugin) {
        this.plugin = plugin;

        this.playerManager = new PlayerManager(this);



    }

    public void setGameState(GameState gameState)  {
        if(this.gameState == gameState.ACTIVE && gameState == gameState.STARTING) return;
        if(this.gameState == gameState) return;

        this.gameState = gameState;

        switch(gameState) {
            case ACTIVE:
                //Do Cool Stuff
                if (this.gameStartCountdown != null) this.gameStartCountdown.cancel();

                getPlayerManager().scatterPlayers();
                break;
            case STARTING:
                //Do Cool Stuff

                this.gameStartCountdown = new GameStartCountdown(this);
                this.gameStartCountdown.runTaskTimer(plugin, 0, 20);
                break;

        }
    }


    public PlayerManager getPlayerManager() {
        return playerManager;
    }



}
