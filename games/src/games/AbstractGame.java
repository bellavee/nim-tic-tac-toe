/* L2 Informatique - Groupe 70
Nom et prénom: VU Nguyen Phuong Vy
Numéro d'étudiant: 21911658 */

package games;

import players.Player;

public abstract class AbstractGame implements Game {
    protected Player first_player;
    protected Player second_player;
    protected Player current_player;

    public AbstractGame(Player p1, Player p2) {
        this.first_player = p1;
        this.second_player = p2;
        this.current_player = p1;
    }

    public Player getCurrentPlayer() {
        return this.current_player;
    }

    public Player changePlayer() {
        if (this.current_player.equals(first_player)) {
            this.current_player = second_player;
        } else {
            this.current_player = first_player;
        }
        return this.current_player;
    }

    protected abstract void doExecute(int index);

    public void execute(int index) {
        doExecute(index);
        changePlayer();
    }

}
