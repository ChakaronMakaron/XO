package Players;

import Field.*;

public class PlayerZero extends Player {
    String symbol = "O";
    
    public PlayerZero(Field field, String name) {
        super(field, name);
    }

    public void play(double position) {
        super.putZero(position);
        this.chosenCells.add((int)position);
    }
}
