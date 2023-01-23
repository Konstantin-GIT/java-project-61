package hexlet.code;


import hexlet.code.games.Calc;
import hexlet.code.games.Even;

import java.util.Scanner;

import static hexlet.code.Engine.engine;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.\n" +
                "1 - Greet\n" +
                "2 - Even\n" +
                "3 - Calc\n" +
                "0 - Exit");
        Scanner scanner = new Scanner(System.in);
        String numberGame = scanner.next();
        if (numberGame.equals("2")) {
            System.out.println("Your choice: " + numberGame);
            engine(new Even());
        } else if (numberGame.equals("3")) {
            System.out.println("Your choice: " + numberGame);
            engine(new Calc());
        }
    }
}
