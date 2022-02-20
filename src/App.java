import java.util.Scanner;

import Field.*;
import Game.*;
import Players.*;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the first \"X\" player ");
        String playerExName = scanner.nextLine();

        System.out.println("Enter the name of the \"O\" player ");
        String playerZeroName = scanner.nextLine();

        // Creating Field
        Field gameField = new Field();

        // Creating Players
        Player playerEx = new PlayerEx(gameField, playerExName);
        Player playerZero = new PlayerZero(gameField, playerZeroName);

        // Creating Game
        Game game = new Game(playerEx, playerZero);

        gameField.showField();

        while (game.keepPlaying) {

            System.out.println(game.currentPlayer.name + " choose a cell, the symbol is: " + game.currentSymbol);
            int position = scanner.nextInt();

            if (gameField.isPositionAvailable(position)) {
                game.currentPlayer.play(position);
            } else {
                System.out.println("This cell is out of range or already occupied!");
                continue;
            }

            gameField.showField();

            if (game.currentPlayer.checkForWin()) {
                System.out.println(game.currentPlayer.name + " has won this game!");
                gameField.clearField();
                playerEx.clearChosenCells();
                playerZero.clearChosenCells();
                scanner.close();
                break;
            } else if (gameField.checkForDraw()) {
                System.out.println("No winner!");
                scanner.close();
                break;
            } else {
                game.changeTurn();
            }
        }
    }
}
