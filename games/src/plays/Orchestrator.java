package plays;

import java.util.Scanner;

import games.Game;
import games.Nim;
import games.TicTacToe;
import players.Human;
import players.Player;

public class Orchestrator {
    Game game;

    public Orchestrator(Game game) {
        this.game = game;
    }

    public void play(Game game) {
        while (!game.isOver()) {
            System.out.println(game.situationToString());
            System.out.println("This is " + game.getCurrentPlayer().getName() + "'s turn");
            game.getCurrentPlayer().chooseMove(game);

            if (game.getWinner() != null) {
                System.out.println("Winner is " + game.getWinner().getName());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to 333 game");

        System.out.print("Enter Player 1's name: ");
        Scanner name = new Scanner(System.in);
        String player_name_1 = name.nextLine();

        System.out.print("Enter Player 2's name: ");
        String player_name_2 = name.nextLine();

        System.out.println("Choose a game you wanna play (1-Nim, 2-TicTacToe) ");
        Scanner move = new Scanner(System.in);
        int choice = move.nextInt();

        Player player1 = new Human(player_name_1, move, choice);
        Player player2 = new Human(player_name_2, move, choice);

        System.out.println("Player 1's name is: " + player1.getName());
        System.out.println("Player 2's name is: " + player2.getName());

        if (choice == 1) {
            System.out.println();
            System.out.println("Welcome to Nim game");
            Nim nim = new Nim(20, 3, player1, player2);
            Orchestrator play_nim = new Orchestrator(nim);
            System.out.println("Initial matches " + nim.getInitialNbMatches());
            play_nim.play(nim);
        }

        if (choice == 2) {
            System.out.println();
            System.out.println("Welcome to TicTacToe");
            TicTacToe ttt = new TicTacToe(player1, player2);
            Orchestrator play_ttt = new Orchestrator(ttt);
            ttt.display();
            ttt.displayIndex();
            play_ttt.play(ttt);
        }
    }
}
