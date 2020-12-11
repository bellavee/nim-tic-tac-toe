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
        this.move = new Scanner(System.in);
        int choice = this.move.nextInt();

        while (!game.isValid(choice)) {
            this.move = new Scanner(System.in);
            choice = this.move.nextInt();
        }

        System.out.println();
        return choice;
    }

    // getName()
    @Override
    public String toString() {
        return this.player;
    }
}