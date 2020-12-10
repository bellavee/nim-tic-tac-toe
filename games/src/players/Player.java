package players;

import games.Game;

public interface Player {
    public int chooseMove(Game game);

    public String toString();
}
