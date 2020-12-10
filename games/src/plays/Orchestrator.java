package plays;

import games.Game;

public class Orchestrator {
    Game game;

    public Orchestrator(Game game) {
        this.game = game;
    }

    public void play() {
        System.out.println("Move valid " + this.game.validMoves());
        while (!this.game.isOver()) {
            System.out.println(this.game.situationToString());
            int move = this.game.getCurrentPlayer().chooseMove(game);
            this.game.execute(move);
            System.out.println(this.game.moveToString(move));

            if (this.game.getWinner() != null) {
                System.out.println("Winner is " + this.game.getWinner().toString());
            }
        }
    }
}
