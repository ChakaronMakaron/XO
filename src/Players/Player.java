package Players;

import java.util.HashSet;
import java.util.Set;
import Field.*;

public class Player {
    
    Field field;
    public String name;
    Set<Integer> chosenCells;

    Player(Field field, String name) {
        this.field = field;
        this.name = name;
        this.chosenCells = new HashSet<>();
    }

    protected void putEx(double position) {
        int rowDefiner = (int)Math.ceil(position / 3);
        int row = rowDefiner - 1;

        int columnDefiner = (int)position - (3 * row);
        int column = 2 * columnDefiner - 1 - 1;

        this.field.fieldArray[row][column] = "X";
    }

    protected void putZero(double position) {
        int rowDefiner = (int)Math.ceil(position / 3.0);
        int row = rowDefiner - 1;

        int columnDefiner = (int)position - (3 * row);
        int column = 2 * columnDefiner - 1 - 1;

        this.field.fieldArray[row][column] = "O";
    }

    public void play(double position) {}

    public void clearChosenCells() {
        this.chosenCells = new HashSet<>();
    }

    public boolean checkForWin() {
        for (int i = 0; i < this.field.victoriousCombinations.size(); i++) {
            if (this.chosenCells.containsAll(this.field.victoriousCombinations.get(i))) {
                return true;
            }
        }

        return false;
    }
}
