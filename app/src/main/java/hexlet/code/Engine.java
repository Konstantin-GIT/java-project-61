package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static void engine(ConsoleGame game) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("May I have your name?");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(game.getRules());
        int counter = 0;
        while (counter < 3) {
            String correctAnswer = game.getQuestionAndCorrectAnswer();
            String answer = scanner.next();
            if (correctAnswer.equals(answer) ) {
                counter++;
                System.out.println("Your answer: " + answer);
                System.out.println("Correct!");
            } else {
                System.out.println("'"+answer+"'" + " is wrong answer ;(. Correct answer was \'" + correctAnswer +"\'.\n" +
                        "Let's try again, " + userName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }
}
