package players;

import playerstests.HumanTests;

public class Test{
    public static void main(String[] args) {
        boolean ok = true;
        HumanTests humanTester = new HumanTests();
        ok = ok && humanTester.testChooseMove();
        System.out.println(ok ? "All tests passed" : "At least one test failed");
    }
}