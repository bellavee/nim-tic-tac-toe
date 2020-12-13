/* L2 Informatique - Groupe 70 CC POO
Nom et prénom: VU Nguyen Phuong Vy
Numéro d'étudiant: 21911658 */

package players;

import java.util.Random;

import games.Game;

public class RandomPlayer implements Player {
    Random rand;

    public RandomPlayer(Random rand) {
        this.rand = rand;
    }

    @Override
    public int chooseMove(Game game) {
        int move = rand.nextInt(game.validMoves().size());
        return game.validMoves().get(move);
    }

    // getName()
    @Override
    public String toString() {
        return "Random player no. " + this.hashCode();
    }

}
