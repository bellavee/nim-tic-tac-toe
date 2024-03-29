/* L2 Informatique - Groupe 70 CC POO
Nom et prénom: VU Nguyen Phuong Vy
Numéro d'étudiant: 21911658 */

package games;

import java.util.ArrayList;

import players.Player;

public class Nim extends AbstractGame {
    private int size;
    private int max_matches;
    private int current_matches;

    public Nim(int size, int max_matches, Player p1, Player p2) {
        super(p1, p2);
        this.size = size;
        this.max_matches = max_matches;
        this.current_matches = size - current_matches;
    }

    public int getInitialNbMatches() {
        return size;
    }

    public int getCurrentNbMatches() {
        return this.current_matches;
    }

    @Override
    public String situationToString() {
        return "The rest " + getCurrentNbMatches() + "\nValid moves " + validMoves();
    }

    @Override
    public String moveToString(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void execute(int index) {
        this.current_matches -= index;
        changePlayer();
    }

    @Override
    public boolean isValid(int index) {
        if (index > 0 && index <= this.max_matches && index <= this.current_matches)
            return true;

        return false;
    }

    @Override
    public ArrayList<Integer> validMoves() {
        ArrayList<Integer> valid_move = new ArrayList<>();
        for (int i = 1; i <= this.max_matches; i++) {
            if (isValid(i))
                valid_move.add(i);
        }
        return valid_move;
    }

    @Override
    public Player getWinner() {
        if (this.current_matches == 0)
            return this.current_player;
        return null;
    }

    @Override
    public boolean isOver() {
        if (getWinner() == null)
            return false;
        else
            return true;
    }

    public Game copy() {
        Nim res = new Nim(this.size, this.max_matches, this.first_player, this.second_player);
        res.current_matches = this.current_matches;
        res.current_player = super.current_player;
        return res;
    }

    @Override
    protected void doExecute(int index) {
        // TODO Auto-generated method stub

    }
}
