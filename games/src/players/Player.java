package players;

import games.Game;

public interface Player {
    Player player2 = null;

    public int chooseMove(Game game);

    public String toString();
}
