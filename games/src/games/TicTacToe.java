package games;

import java.util.ArrayList;

import players.Player;

public class TicTacToe extends AbstractGame {
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

    public boolean wins(Player P, int row, int col, int drow, int dcol) {
        if (this.tab[row][col] == null) {
            return false;
        }
        if (this.tab[row][col] != this.tab[row + drow][col + dcol]) {
            return false;
        }
        if (this.tab[row][col] != this.tab[row + 2 * drow][col + 2 * dcol]) {
            return false;
        }
        return true;
    }

    @Override
    public Player getWinner() {
        Player winner = this.current_player;

        // Horizontals
        if (wins(winner, 0, 0, 0, 1))
            return winner;
        if (wins(winner, 1, 0, 0, 1))
            return winner;
        if (wins(winner, 2, 0, 0, 1))
            return winner;

        // Verticals
        if (wins(winner, 0, 0, 1, 0))
            return winner;
        if (wins(winner, 0, 1, 1, 0))
            return winner;
        if (wins(winner, 0, 2, 1, 0))
            return winner;

        // Diagonals
        if (wins(winner, 0, 0, 1, 1))
            return winner;
        if (wins(winner, 2, 0, -1, 1))
            return winner;

        return null;
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
    public boolean isOver() {
        if (tie()) {
            System.out.println("Tie");
            return true;
        }

        if (getWinner() == null) {
            return false;
        }

        else {
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
