package games;

import java.util.ArrayList;

import players.Player;

public interface Game {
    public Player getCurrentPlayer();

    public ArrayList validMoves();

    public void execute(int index);

    public boolean isValid(int index);

    public boolean isOver();

    public Player getWinner();

    public String situationToString();
}
