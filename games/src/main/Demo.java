package main;

import java.util.Random;
import java.util.Scanner;

import games.Nim;
import games.TicTacToe;
import games.TicTacToeWithHints;
import players.Human;
import players.NegamaxPlayer;
import players.Player;
import players.RandomPlayer;
import plays.Orchestrator;

public class Demo {

    // =============== to play ===============

    public static void nim(int size, int max, Player p1, Player p2) {
        Nim game = new Nim(size, max, p1, p2);
        Orchestrator orchestrator = new Orchestrator(game);
        orchestrator.play();
    }

    public static void tictactoe(Player p1, Player p2) {
        TicTacToe game = new TicTacToe(p1, p2);
        Orchestrator orchestrator = new Orchestrator(game);
        orchestrator.play();
    }

    public static void tictactoewithhints(Player p1, Player p2) {
        TicTacToeWithHints game = new TicTacToeWithHints(p1, p2);
        Orchestrator orchestrator = new Orchestrator(game);
        orchestrator.play();
    }

    // =============== main ===============

    public static void main(String[] args) {
        System.out.println("Choose a game you wanna play\n1-Nim\t2-TicTacToe\t3-TicTacToeWithHints");
        Scanner choice = new Scanner(System.in);
        int game_choose = choice.nextInt();

        System.out.println("Choose a mode\n1-PvP\t2-PvE-random\t3-PvE-ai\t4-EvE-random\t5-EvE-ai-random\t6-EvE-ai");
        int game_mode = choice.nextInt();

        // =============== player vs player ===============

        if (game_mode == 1) {
            System.out.print("Enter Player 1's name: ");
            Scanner name = new Scanner(System.in);
            String p1_name = name.nextLine();

            System.out.print("Enter Player 2's name: ");
            String p2_name = name.nextLine();
            System.out.println();

            Scanner scanner = new Scanner(System.in);
            Player p1 = new Human(p1_name, scanner);
            Player p2 = new Human(p2_name, scanner);

            if (game_choose == 1) {
                nim(13, 3, p1, p2);
                scanner.close();
            }

            if (game_choose == 2) {
                tictactoe(p1, p2);
                scanner.close();
            }

            if (game_choose == 3) {
                tictactoewithhints(p1, p2);
                scanner.close();
            }

            name.close();
        }

        // =============== player vs random ===============

        if (game_mode == 2) {
            System.out.print("Enter your name: ");
            Scanner name = new Scanner(System.in);
            String p_name = name.nextLine();
            System.out.println();

            Scanner scanner = new Scanner(System.in);
            Random rand = new Random();
            Player p1 = new Human(p_name, scanner);
            Player p2 = new RandomPlayer(rand);

            if (game_choose == 1) {
                nim(13, 3, p1, p2);
                scanner.close();
            }

            if (game_choose == 2) {
                tictactoe(p1, p2);
                scanner.close();
            }

            if (game_choose == 3) {
                tictactoewithhints(p1, p2);
                scanner.close();
            }

            name.close();
        }

        // =============== player vs ai ===============

        if (game_mode == 3) {
            System.out.print("Enter your name: ");
            Scanner name = new Scanner(System.in);
            String p_name = name.nextLine();

            Scanner scanner = new Scanner(System.in);
            Player p1 = new Human(p_name, scanner);
            Player p2 = new NegamaxPlayer();

            if (game_choose == 1) {
                nim(13, 3, p1, p2);
                scanner.close();
            }

            if (game_choose == 2) {
                tictactoe(p1, p2);
                scanner.close();
            }

            if (game_choose == 3) {
                tictactoewithhints(p1, p2);
                scanner.close();
            }

            name.close();
        }

        // =============== random vs random ===============

        if (game_mode == 4) {
            Scanner scanner = new Scanner(System.in);
            Random rand = new Random();
            Player p1 = new RandomPlayer(rand);
            Player p2 = new RandomPlayer(rand);

            if (game_choose == 1) {
                nim(13, 3, p1, p2);
                scanner.close();
            }

            if (game_choose == 2) {
                tictactoe(p1, p2);
                scanner.close();
            }

            if (game_choose == 3) {
                tictactoewithhints(p1, p2);
                scanner.close();
            }
        }

        // =============== random vs ai ===============

        if (game_mode == 5) {
            Scanner scanner = new Scanner(System.in);
            Random rand = new Random();
            Player p1 = new RandomPlayer(rand);
            Player p2 = new NegamaxPlayer();

            if (game_choose == 1) {
                nim(13, 3, p1, p2);
                scanner.close();
            }

            if (game_choose == 2) {
                tictactoe(p1, p2);
                scanner.close();
            }

            if (game_choose == 3) {
                tictactoewithhints(p1, p2);
                scanner.close();
            }
        }

        // =============== ai vs ai ===============

        if (game_mode == 6) {
            Scanner scanner = new Scanner(System.in);
            Player p1 = new NegamaxPlayer();
            Player p2 = new NegamaxPlayer();

            if (game_choose == 1) {
                nim(13, 3, p1, p2);
                scanner.close();
            }

            if (game_choose == 2) {
                tictactoe(p1, p2);
                scanner.close();
            }

            if (game_choose == 3) {
                tictactoewithhints(p1, p2);
                scanner.close();
            }
        }
    }
}
