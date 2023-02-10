package hexlet.code.games;

import java.util.Random;
import static hexlet.code.Engine.run;

public class Prime {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int INDEX_OF_QUESTION = 0;
    private static final int INDEX_OF_CORRECT_ANSWER = 1;
    private static final int MAX_NUMBER_TO_INTERVAL = 100;
    private static final int NUMBER_OF_ROUND = 3;

    public static void startPrimeGame() {
        String[][] questionsAndAnswersOfGame = new String[NUMBER_OF_ROUND][];
        for (int i = 0; i < NUMBER_OF_ROUND; i++) {
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
