package games;

import java.util.ArrayList;

import players.Player;

public interface Game {

    public void execute(int index);

    public Player getCurrentPlayer();

    public abstract boolean isValid(int index);

    public abstract ArrayList<Integer> validMoves();

    public abstract boolean isOver();

    public abstract String moveToString(int index);

    public abstract String situationToString();

    public abstract Player getWinner();

    public Game copy();

}
