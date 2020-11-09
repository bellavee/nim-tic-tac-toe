package players;

import java.util.Scanner;

import games.Game;

public class Human implements Player {
    private String player;
    private Scanner move;
    private int choice;

    public Human(String player, Scanner move, int choice) {
        this.player = player;
        this.move = move;
        this.choice = choice;
    }

    @Override
    public int chooseMove(Game game) {
        System.out.println("Make a move's number (-1 to exit) ");
        System.out.println("Move valid " + game.validMoves());
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();

        if (choice == -1) {
            System.exit(0);
        }

        if (!game.isValid(choice)) {
            System.out.println("Move is not valid ");
            this.move = new Scanner(System.in);
        }

        else {
            game.execute(choice);
            System.out.println("Move valided " + game.validMoves());
        }

        System.out.println();
        return choice;
    }

    @Override
    public String getName() {
        return this.player;
    }

}
