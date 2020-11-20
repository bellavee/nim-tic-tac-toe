package games;

import java.util.ArrayList;

import players.Player;

public class Nim extends AbstractGame {
    private int taille;
    private int max_allu;
    private int courant_allu;

    public Nim(int taille, int max_allu, Player p1, Player p2) {
        super(p1, p2);
        this.taille = taille;
        this.max_allu = max_allu;
        this.courant_allu = taille - courant_allu;
    }

    public int getInitialNbMatches() {
        return taille;
    }

    public int getCurrentNbMatches() {
        return this.courant_allu;
    }

    @Override
    public String situationToString() {
        return "The rest: " + this.courant_allu;
    }

    public void changePlayer() {
        if (this.current_player.equals(first_player)) {
            this.current_player = second_player;
        } else {
            this.current_player = first_player;
        }
    }

    @Override
    public void execute(int index) {
        this.courant_allu -= index;
        changePlayer();
    }

    @Override
    public boolean isValid(int index) {
        if (index > 0 && index <= this.max_allu && index <= this.courant_allu) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ArrayList validMoves() {
        ArrayList<Integer> move_valid = new ArrayList<Integer>();
        for (int i = 1; i <= this.max_allu; i++) {
            if (isValid(i)) {
                move_valid.add(i);
            }
        }
        return move_valid;
    }

    @Override
    public Player getWinner() {
        if (this.courant_allu == 0) {
            return this.current_player;
        }
        return null;
    }

    @Override
    public boolean isOver() {
        if (getWinner() == null) {
            return false;
        } else {
            return true;
        }
    }

}
