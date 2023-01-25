package hexlet.code;

import java.util.Scanner;
import static hexlet.code.Cli.startGame;
import static hexlet.code.games.Calc.startCalcGame;
import static hexlet.code.games.Even.startEvenGame;
import static hexlet.code.games.Prime.startPrimeGame;
import static hexlet.code.games.Gcd.startGcdGame;
import static hexlet.code.games.Progression.startProgressionGame;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.\n"
                + "1 - Greet\n"
                + "2 - Even\n"
                + "3 - Calc\n"
                + "4 - GCD\n"
                + "5 - Progression\n"
                + "6 - Prime\n"
                + "0 - Exit");
        Scanner scanner = new Scanner(System.in);
        String numberGame = scanner.next();
        if (numberGame.equals("1")) {
            System.out.println("Your choice: " + numberGame);
            startGame();
        } else if (numberGame.equals("2")) {
            System.out.println("Your choice: " + numberGame);
            startEvenGame();
        } else if (numberGame.equals("3")) {
            System.out.println("Your choice: " + numberGame);
            startCalcGame();
        } else if (numberGame.equals("4")) {
            System.out.println("Your choice: " + numberGame);
            startGcdGame();
        } else if (numberGame.equals("5")) {
            System.out.println("Your choice: " + numberGame);
            startProgressionGame();
        } else if (numberGame.equals("6")) {
            System.out.println("Your choice: " + numberGame);
             startPrimeGame();
        }
    }
}
