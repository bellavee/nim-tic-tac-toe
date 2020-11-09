package games;

import java.util.ArrayList;

import players.Player;

public class TicTacToe extends AbstractGame implements Game {
    private Player tab[][] = new Player[3][3];
    private int tab_index[][] = new int[3][3];

    public TicTacToe(Player p1, Player p2) {
        super(p1, p2);
        int coup = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.tab[i][j] = null;
                this.tab_index[i][j] = coup;
                coup += 1;
            }
        }
    }

    public void display() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.tab[i][j] == null)
                    System.out.print("." + "\t");

                if (this.tab[i][j] == first_player) {
                    System.out.print("x" + "\t");
                }

                if (this.tab[i][j] == second_player) {
                    System.out.print("o" + "\t");
                }

            }
            System.out.println();
        }
    }

    public void displayIndex() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(this.tab_index[i][j] + "\t");
            }
            System.out.println();
        }
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
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (index == this.tab_index[i][j]) {
                    if (this.current_player.equals(first_player)) {
                        this.tab[i][j] = first_player;
                    } else {
                        this.tab[i][j] = second_player;
                    }
                }
            }
        }

        display();
        if (getWinner() == null) {
            changePlayer();
        }
    }

    @Override
    public boolean isValid(int index) {
        if (index > 8 || index < 0) {
            return false;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (index == this.tab_index[i][j] && this.tab[i][j] == first_player) {
                    return false;
                }

                else if (index == this.tab_index[i][j] && this.tab[i][j] == second_player) {
                    return false;
                }
            }
        }
        return true;
    }

    public ArrayList validMoves() {
        ArrayList<Integer> move_valid = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (isValid(this.tab_index[i][j])) {
                    move_valid.add(this.tab_index[i][j]);
                }
            }
        }
        return move_valid;
    }

    public boolean checkWin(Player p1, Player p2, Player p3) {
        return ((p1 != null) && (p1 == p2) && (p2 == p3) && (p3 == p1));
    }

    @Override
    public boolean wins() {
        for (int i = 0; i < 3; i++) {
            if (checkWin(this.tab[i][0], this.tab[i][1], this.tab[i][2])) {
                return true;
            }

            if (checkWin(this.tab[0][i], this.tab[1][i], this.tab[2][i])) {
                return true;
            }
        }

        if (checkWin(this.tab[0][0], this.tab[1][1], this.tab[2][2])
                || (checkWin(this.tab[0][2], this.tab[1][1], this.tab[2][0]))) {
            return true;
        }

        return false;
    }

    public boolean tie() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.tab[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public Player getWinner() {
        if (wins()) {
            return this.current_player;
        }
        if (tie() && !wins()) {
            System.out.println("Tie!");
            System.exit(0);
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

    @Override
    public String situationToString() {
        return "------";
    }

    @Override
    protected void doExecute(int index) {
        // TODO Auto-generated method stub

    }

}
