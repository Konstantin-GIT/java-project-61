package hexlet.code;

import java.util.Scanner;
import static hexlet.code.Cli.greet;
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

        switch (numberGame) {
            case "1":
                System.out.println("Your choice: " + numberGame);
                greet();
                break;
            case "2":
                System.out.println("Your choice: " + numberGame);
                startEvenGame();
                break;
            case "3":
                System.out.println("Your choice: " + numberGame);
                startCalcGame();
                break;
            case "4":
                System.out.println("Your choice: " + numberGame);
                startGcdGame();
                break;
            case "5":
                System.out.println("Your choice: " + numberGame);
                startProgressionGame();
                break;
            case "6":
                System.out.println("Your choice: " + numberGame);
                startPrimeGame();
                break;
            default:
                throw new Error("Incorrect character when entering the game numbers");
        }
    }
}
