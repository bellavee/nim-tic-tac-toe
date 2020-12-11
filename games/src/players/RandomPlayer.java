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
        int choice = rand.nextInt(game.validMoves().size());
        return game.validMoves().get(choice);
    }

    // getName()
    @Override
    public String toString() {
        return "Random player no. " + this.hashCode();
    }

}
