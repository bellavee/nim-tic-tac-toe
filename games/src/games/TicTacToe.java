/* L2 Informatique - Groupe 70
Nom et prénom: VU Nguyen Phuong Vy
Numéro d'étudiant: 21911658 */

package games;

import java.util.ArrayList;

import players.Player;

public class TicTacToe extends AbstractGame {
    protected Player tab[][] = new Player[3][3];

    public TicTacToe(Player p1, Player p2) {
        super(p1, p2);
    }

    @Override
    public void execute(int index) {
        int row = index / 3;
        int col = index % 3;
        if (this.current_player.equals(first_player))
            this.tab[row][col] = first_player;
        else
            this.tab[row][col] = second_player;

        if (getWinner() == null)
            changePlayer();
    }

    @Override
    public boolean isValid(int index) {
        ArrayList<Integer> move = validMoves();
        return move.contains(index);
    }

    @Override
    public ArrayList<Integer> validMoves() {
        ArrayList<Integer> valid_move = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.tab[i][j] == null) {
                    valid_move.add(i * 3 + j);
                }
            }
        }
        return valid_move;
    }

    public boolean wins(Player p, int row, int col, int drow, int dcol) {
        if (this.tab[row][col] == null)
            return false;

        if (this.tab[row][col] != this.tab[row + drow][col + dcol])
            return false;

        if (this.tab[row][col] != this.tab[row + 2 * drow][col + 2 * dcol])
            return false;

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

    @Override
    public boolean isOver() {
        if (validMoves().isEmpty())
            return true;

        if (getWinner() == null)
            return false;

        else
            return true;
    }

    @Override
    public String moveToString(int index) {
        return index + " = " + "(" + index / 3 + ", " + index % 3 + ")";
    }

    @Override
    public String situationToString() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.tab[i][j] == null)
                    System.out.print(".\t");

                if (this.tab[i][j] == first_player)
                    System.out.print("x\t");

                if (this.tab[i][j] == second_player)
                    System.out.print("o\t");
            }
            System.out.println();
        }

        System.out.println("Valid moves ");
        for (int move : validMoves())
            System.out.println(moveToString(move));

        return "\n";
    }

    public Game copy() {
        TicTacToe res = new TicTacToe(this.first_player, this.second_player);
        res.tab = new Player[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                res.tab[i][j] = this.tab[i][j];
            }
        }
        res.current_player = super.current_player;
        return res;
    }

    @Override
    protected void doExecute(int index) {
        // TODO Auto-generated method stub
    }

}
