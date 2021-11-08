package me.agro.battleroyale.listeners;


import me.agro.battleroyale.managers.GameManager;
import me.agro.battleroyale.managers.GameState;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class Command implements CommandExecutor {


    private GameManager gameManager;

    public Command(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {

        gameManager.setGameState(GameState.STARTING);
        return false;
    }
}
