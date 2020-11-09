package games;

import players.Player;

public abstract class AbstractGame {
    protected Player first_player;
    protected Player second_player ;
    protected Player current_player;

    public AbstractGame(Player p1, Player p2){
        this.first_player = p1;
        this.second_player = p2;
        this.current_player = p1;
    }

    public Player getCurrentPlayer(){
        return this.current_player;
    }

    public abstract void execute(int index);
    

}
