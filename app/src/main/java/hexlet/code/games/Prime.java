package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import static hexlet.code.Engine.run;

public class Prime {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MAX_NUMBER_TO_INTERVAL = 100;

    public static void startPrimeGame() {
        String[][] questionsAndAnswersOfGame = new String[Engine.NUMBER_OF_ROUNDS][];
        for (int i = 0; i < questionsAndAnswersOfGame.length; i++) {
            questionsAndAnswersOfGame[i] = generateRoundData();
        }
        run(GAME_DESCRIPTION, questionsAndAnswersOfGame);
    }

    private static String[] generateRoundData() {
        Random random = new Random();
        int number = random.nextInt(1, MAX_NUMBER_TO_INTERVAL);
        String question = Integer.toString(number);
        String answer = isPrime(number) ? "yes" : "no";
        return new String[] {question, answer};
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
