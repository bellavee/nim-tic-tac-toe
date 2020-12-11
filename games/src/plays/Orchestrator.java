package plays;

import games.Game;

public class Orchestrator {
    Game game;

    public Orchestrator(Game game) {
        this.game = game;
    }

    public void play() {
        System.out.println(this.game.situationToString());

        while (!this.game.isOver()) {
            System.out.println("This is " + this.game.getCurrentPlayer().toString() + "'s turn\n");
            int move = this.game.getCurrentPlayer().chooseMove(game);
            this.game.execute(move);
            System.out.println(this.game.situationToString());

            if (this.game.getWinner() != null)
                System.out.println("Winner is " + this.game.getWinner().toString());
        }
        if (this.game.getWinner() == null)
            System.out.println("Draw!");
    }
}
