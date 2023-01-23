package hexlet.code;


import java.util.Scanner;

import static hexlet.code.Cli.startGame;
import static hexlet.code.Even.evenGame;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.\n" +
                "1 - Greet\n" +
                "2 - Even\n" +
                "0 - Exit");
        Scanner scanner = new Scanner(System.in);
        String numberGame = scanner.next();
        if (numberGame.equals("2")) {
            System.out.println("Your choice: " + numberGame);
            evenGame();
        }
    }
}
