package main;

import java.util.Random;
import java.util.Scanner;

import games.Nim;
import games.TicTacToe;
import players.Human;
import players.NegamaxPlayer;
import players.Player;
import players.RandomPlayer;
import plays.Orchestrator;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Choose a game you wanna play\n1-Nim\t2-TicTacToe");
        Scanner choice = new Scanner(System.in);
        int game_choose = choice.nextInt();

        System.out.println("Do you want to play\n1-with player\t2-with random\t3-with negamax");
        int game_mode = choice.nextInt();

        if (game_mode == 1) {
            System.out.print("Enter Player 1's name: ");
            Scanner name = new Scanner(System.in);
            String player_name_1 = name.nextLine();

            System.out.print("Enter Player 2's name: ");
            String player_name_2 = name.nextLine();

            if (game_choose == 1) {
                Scanner scanner = new Scanner(System.in);
                Player player1 = new Human(player_name_1, scanner);
                Player player2 = new Human(player_name_2, scanner);
                Nim game = new Nim(13, 3, player1, player2);
                Orchestrator orchestrator = new Orchestrator(game);
                orchestrator.play();
                scanner.close();
            }

            if (game_choose == 2) {
                Scanner scanner = new Scanner(System.in);
                Player player1 = new Human(player_name_1, scanner);
                Player player2 = new Human(player_name_2, scanner);
                TicTacToe game = new TicTacToe(player1, player2);
                Orchestrator orchestrator = new Orchestrator(game);
                orchestrator.play();
                scanner.close();
            }

        }

        if (game_mode == 2) {
            System.out.print("Enter your name: ");
            Scanner name = new Scanner(System.in);
            String player = name.nextLine();

            if (game_choose == 1) {
                Scanner scanner = new Scanner(System.in);
                Random rand = new Random();
                Player player1 = new Human(player, scanner);
                Player player2 = new RandomPlayer(rand);
                Nim game = new Nim(13, 3, player1, player2);
                Orchestrator orchestrator = new Orchestrator(game);
                orchestrator.play();
                scanner.close();
            }

            if (game_choose == 2) {
                Scanner scanner = new Scanner(System.in);
                Random rand = new Random();
                Player player1 = new Human(player, scanner);
                Player player2 = new RandomPlayer(rand);
                TicTacToe game = new TicTacToe(player1, player2);
                Orchestrator orchestrator = new Orchestrator(game);
                orchestrator.play();
                scanner.close();
            }
        }

        if (game_mode == 3) {
            System.out.print("Enter your name: ");
            Scanner name = new Scanner(System.in);
            String player = name.nextLine();

            if (game_choose == 1) {
                Scanner scanner = new Scanner(System.in);
                Player player1 = new Human(player, scanner);
                Player player2 = new NegamaxPlayer();
                Nim game = new Nim(13, 3, player1, player2);
                Orchestrator orchestrator = new Orchestrator(game);
                orchestrator.play();
                scanner.close();
            }

            if (game_choose == 2) {
                Scanner scanner = new Scanner(System.in);
                Player player1 = new Human(player, scanner);
                Player player2 = new NegamaxPlayer();
                TicTacToe game = new TicTacToe(player1, player2);
                Orchestrator orchestrator = new Orchestrator(game);
                orchestrator.play();
                scanner.close();
            }
        }
    }
}
