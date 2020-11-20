package players;

import games.AbstractGame;

public interface Player {
    public int chooseMove(AbstractGame game);

    public String getName();
}
