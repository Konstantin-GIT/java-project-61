package hexlet.code;


import hexlet.code.games.*;

import java.util.Scanner;

import static hexlet.code.Cli.startGame;
import static hexlet.code.Engine.engine;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.\n" +
                "1 - Greet\n" +
                "2 - Even\n" +
                "3 - Calc\n" +
                "4 - GCD\n" +
                "5 - Progression\n" +
                "6 - Prime\n" +
                "0 - Exit");
        Scanner scanner = new Scanner(System.in);
        String numberGame = scanner.next();
        if (numberGame.equals("1")) {
            System.out.println("Your choice: " + numberGame);
            startGame();
        } else if (numberGame.equals("2")) {
            System.out.println("Your choice: " + numberGame);
            engine(new Even());
        } else if (numberGame.equals("3")) {
            System.out.println("Your choice: " + numberGame);
            engine(new Calc());
        } else if (numberGame.equals("4")) {
            System.out.println("Your choice: " + numberGame);
            engine(new Gcd());
        } else if (numberGame.equals("5")) {
            System.out.println("Your choice: " + numberGame);
            engine(new Progression());
        } else if (numberGame.equals("6")) {
            System.out.println("Your choice: " + numberGame);
            engine(new Prime());
        }
    }
}
