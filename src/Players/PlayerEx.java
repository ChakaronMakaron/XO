package Players;

import Field.*;

public class PlayerEx extends Player {
    String symbol = "X";
    
    public PlayerEx(Field field, String name) {
        super(field, name);
    }

    public void play(double position) {
        super.putEx(position);
        this.chosenCells.add((int)position);
    }
}
