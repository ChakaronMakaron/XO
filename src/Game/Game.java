package Game;

import Players.*;
import Field.*;

public class Game {
    
    Field gameField;
    public boolean quit = false;
    public boolean keepPlaying = true;
    
    private Player playerEx;
    private Player playerZero;
    public Player currentPlayer;
    public String currentSymbol;
    
    public Game(Player playerEx, Player playerZero) {
        this.playerEx = playerEx;
        this.playerZero = playerZero;
        this.currentPlayer = playerEx;
        this.currentSymbol = "X";
    }

    public void changeTurn() {
        if (currentPlayer == playerEx) {
            this.currentPlayer = playerZero;
            this.currentSymbol = "O";
        } else {
            this.currentPlayer = playerEx;
            this.currentSymbol = "X";
        }
    }

    // Might add methond initField, initPlayers
}
