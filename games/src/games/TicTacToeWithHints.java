/* L2 Informatique - Groupe 70
Nom et prénom: VU Nguyen Phuong Vy
Numéro d'étudiant: 21911658 */

package games;

import java.util.ArrayList;

import players.Player;

public class TicTacToeWithHints extends TicTacToe {
    public TicTacToeWithHints(Player p1, Player p2) {
        super(p1, p2);
    }

    public void unExecute(int index) {
        this.tab[index / 3][index % 3] = null;
    }

    public ArrayList<Integer> hints() {
        ArrayList<Integer> hints = new ArrayList<>();
        for (int move : validMoves()) {
            Game copy = copy();
            copy.execute(move);
            if (copy.getWinner() != null)
                hints.add(move);

            if (isOver())
                hints.clear();
        }

        return hints;
    }

    @Override
    public String situationToString() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.tab[i][j] == null)
                    System.out.print(".\t");

                if (this.tab[i][j] == first_player) {
                    System.out.print("x\t");
                }

                if (this.tab[i][j] == second_player) {
                    System.out.print("o\t");
                }

            }
            System.out.println();
        }

        System.out.println("Valid moves ");
        for (int move : validMoves()) {
            System.out.println(moveToString(move));
        }

        return "Hints " + hints();
    }
}
