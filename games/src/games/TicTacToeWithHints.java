package games;

import java.util.ArrayList;

import players.Player;

public class TicTacToeWithHints extends TicTacToe {
    public TicTacToeWithHints(Player p1, Player p2) {
        super(p1, p2);
    }

    public ArrayList<Integer> hints() {
        ArrayList<Integer> hints = new ArrayList<Integer>();
        return hints;
    }
}
