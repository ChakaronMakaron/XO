package Field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Field {

    public String[][] fieldArray;
    public List<Set<Integer>> victoriousCombinations;
    
    // Constructor
    public Field() {
        this.fieldArray = getEmptyField();
        this.victoriousCombinations = getVictoriousCombinations();
    }

    // Field related methods
    private List<Set<Integer>> getVictoriousCombinations() {
        List<Set<Integer>> combs = new ArrayList<>();

        combs.add(new HashSet<>(Arrays.asList(1, 2, 3)));
        combs.add(new HashSet<>(Arrays.asList(4, 5, 6)));
        combs.add(new HashSet<>(Arrays.asList(7, 8, 9)));
        combs.add(new HashSet<>(Arrays.asList(1, 4, 7)));
        combs.add(new HashSet<>(Arrays.asList(2, 5, 8)));
        combs.add(new HashSet<>(Arrays.asList(3, 6, 9)));
        combs.add(new HashSet<>(Arrays.asList(1, 5, 9)));
        combs.add(new HashSet<>(Arrays.asList(3, 5, 7)));

        return combs;
    }

    private String[][] getEmptyField() {
        String[][] field = new String[][] {{" ", " | ", " ", " | ", " "},
                                           {" ", " | ", " ", " | ", " "},
                                           {" ", " | ", " ", " | ", " "}};
        return field;
    }

    public void clearField() {
        this.fieldArray = getEmptyField();
    }

    public void showField() {
        System.out.println("");
        for (int i = 0; i < this.fieldArray.length; i++) {
            for (int j = 0; j < this.fieldArray[0].length; j++) {
                System.out.print(this.fieldArray[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
    // **********

    // Gameplay related methods
    public boolean isPositionAvailable(double position) {
        if (position < 0 || position > 9) {return false;}

        int rowDefiner = (int)Math.ceil(position / 3.0);
        int row = rowDefiner - 1;
        
        int columnDefiner = (int)position - (3 * row);
        int column = 2 * columnDefiner - 1 - 1;

        return this.fieldArray[row][column].equals(" ");
    }

    public boolean checkForDraw() {
        for (int i = 1; i <= 9; i++) {
            if (isPositionAvailable(i)) {
                return false;
            }
        }

        return true;
    }
    // **********
}
