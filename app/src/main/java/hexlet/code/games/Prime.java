package hexlet.code.games;

import java.util.Random;
import static hexlet.code.Engine.run;

public class Prime {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int INDEX_OF_QUESTION = 0;
    private static final int INDEX_OF_CORRECT_ANSWER = 1;
    private static final int MAX_NUMBER_TO_INTERVAL = 100;
    private static final int SIZE_ARRAY_FOR_QUESTIONS_AND_ANSWERS = 2;
    private static final int NUMBER_OF_ROUND = 3;

    public static void startPrimeGame() {
        String[][] questionsAndAnswersOfGame = new String[NUMBER_OF_ROUND][SIZE_ARRAY_FOR_QUESTIONS_AND_ANSWERS];
        for (int i = 0; i < questionsAndAnswersOfGame.length; i++) {
            questionsAndAnswersOfGame[i] = generateRoundData();
        }
        run(GAME_DESCRIPTION, questionsAndAnswersOfGame);
    }

    private static String[] generateRoundData() {
        String[] questionAndAnswerOfGame = new String[SIZE_ARRAY_FOR_QUESTIONS_AND_ANSWERS];
        Random random = new Random();
        int number = random.nextInt(1, MAX_NUMBER_TO_INTERVAL);
        questionAndAnswerOfGame[INDEX_OF_QUESTION] = Integer.toString(number);
        questionAndAnswerOfGame[INDEX_OF_CORRECT_ANSWER] = isPrime(number) ? "yes" : "no";
        return questionAndAnswerOfGame;
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
