/* L2 Informatique - Groupe 70
Nom et prénom: VU Nguyen Phuong Vy
Numéro d'étudiant: 21911658 */

package players;

import games.Game;

public class NegamaxPlayer implements Player {

    public int evaluate(Game game) {
        Player current_winner = game.getWinner();
        Player current_player = game.getCurrentPlayer();
        int res;
        if (current_winner != null && current_winner == current_player)
            return 1;

        else if (current_winner == null && game.validMoves().isEmpty())
            return 0;

        else if (current_winner != null && current_winner != current_player)
            return -1;

        else {
            res = -9999;
            for (int move : game.validMoves()) {
                Game copy = game.copy();
                copy.execute(move);
                int eval = -evaluate(copy);

                if (res == -9999 || eval > res)
                    res = eval;
            }
            return res;
        }
    }

    @Override
    public int chooseMove(Game game) {
        int best_val = -9999;
        int best_move = 0;
        for (int move : game.validMoves()) {
            Game copy = game.copy();
            copy.execute(move);
            int eval = -evaluate(copy);
            if (best_val == -9999 || eval > best_val) {
                best_val = eval;
                best_move = move;
            }
        }
        return best_move;
    }

    // getName()
    @Override
    public String toString() {
        return "Negamax player no." + this.hashCode();
    }
}
