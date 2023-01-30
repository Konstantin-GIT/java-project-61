package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static final int NUMBER_OF_ROUNDS = 3;

    private static final int INDEX_OF_QUESTION = 0;

    private static final int INDEX_OF_CORRECT_ANSWER = 1;

    public static void engine(String gameDescription, String[][] questionsAndAnswersOfGame) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("May I have your name?");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(gameDescription);
        int counter = 0;

        while (counter < NUMBER_OF_ROUNDS) {
            String question = questionsAndAnswersOfGame[counter][INDEX_OF_QUESTION];
            System.out.println("Question: " + question);
            String correctAnswer = questionsAndAnswersOfGame[counter][INDEX_OF_CORRECT_ANSWER];
            String answerUser = scanner.next();

            if (correctAnswer.equals(answerUser)) {
                counter++;
                System.out.println("Your answer: " + answerUser);
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answerUser + "'" + " is wrong answer ;(. Correct answer was \'"
                        + correctAnswer + "\'.\n" + "Let's try again, " + userName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }
}