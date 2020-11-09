package games;

import gamestests.AbstractGameTests;
import gamestests.NimTests;
import gamestests.TicTacToeTests;

public class Test {
    public static void main(String[] args) {
        boolean ok = true;

        AbstractGameTests abstractGameTester = new AbstractGameTests();
        ok = ok && abstractGameTester.testGetCurrentPlayer();
        // ok = ok && abstractGameTester.testExecute();

        NimTests nimTester = new NimTests();
        ok = ok && nimTester.testGetInitialNbMatches();
        ok = ok && nimTester.testGetCurrentNbMatches();
        ok = ok && nimTester.testGetCurrentPlayer();
        ok = ok && nimTester.testExecute();
        // ok = ok && nimTester.testIsValid();
        // ok = ok && nimTester.testValidMoves();
        ok = ok && nimTester.testIsOver();
        ok = ok && nimTester.testGetWinner();

        TicTacToeTests ticTacToeTester = new TicTacToeTests();
        ok = ok && ticTacToeTester.testGetCurrentPlayer();
        ok = ok && ticTacToeTester.testExecuteAndIsValid();
        ok = ok && ticTacToeTester.testValidMoves();
        // ok = ok && ticTacToeTester.testWins();
        // ok = ok && ticTacToeTester.testGetWinner();
        // ok = ok && ticTacToeTester.testIsOver();

        // // Si la version du morpion avec indices (qui est optionnelle) a été réalisée
        // TicTacToeWithHintsTests ticTacToeWithHintsTester = new
        // TicTacToeWithHintsTests();
        // ok = ok && ticTacToeWithHintsTester.testGetCurrentPlayer();
        // ok = ok && ticTacToeWithHintsTester.testExecuteAndIsValid();
        // ok = ok && ticTacToeWithHintsTester.testValidMoves();
        // ok = ok && ticTacToeWithHintsTester.testWins();
        // ok = ok && ticTacToeWithHintsTester.testGetWinner();
        // ok = ok && ticTacToeWithHintsTester.testIsOver();
        // ok = ok && ticTacToeWithHintsTester.testHints();

        System.out.println(ok ? "All tests passed" : "At least one test failed");
    }
}