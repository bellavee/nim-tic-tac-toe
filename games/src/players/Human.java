/* L2 Informatique - Groupe 70 CC POO
Nom et prénom: VU Nguyen Phuong Vy
Numéro d'étudiant: 21911658 */

package players;

import java.util.Scanner;

import games.Game;

public class Human implements Player {
    private String player;
    private Scanner move;

    public Human(String player, Scanner move) {
        this.player = player;
        this.move = move;
    }

    @Override
    public int chooseMove(Game game) {
        int choice = this.move.nextInt();

        while (!game.isValid(choice))
            choice = this.move.nextInt();

        return choice;
    }

    // getName()
    @Override
    public String toString() {
        return this.player;
    }
}