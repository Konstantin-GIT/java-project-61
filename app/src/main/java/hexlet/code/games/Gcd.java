package hexlet.code.games;

import java.util.Random;
import static hexlet.code.Engine.run;

public class Gcd {
    private static final String GAME_DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final int INDEX_OF_QUESTION = 0;
    private static final int INDEX_OF_CORRECT_ANSWER = 1;
    private static final int MAX_NUMBER_TO_INTERVAL = 100;
    private static final int SIZE_ARRAY_FOR_QUESTIONS_AND_ANSWERS = 2;
    private static final int NUMBER_OF_ROUND = 3;

    public static void startGcdGame() {
        String[][] questionsAndAnswersOfGame = new String[NUMBER_OF_ROUND][SIZE_ARRAY_FOR_QUESTIONS_AND_ANSWERS];
        for (int i = 0; i < questionsAndAnswersOfGame.length; i++) {
            questionsAndAnswersOfGame[i] = generateRoundData();
        }
        run(GAME_DESCRIPTION, questionsAndAnswersOfGame);
    }

    private static String[] generateRoundData() {
        String[] questionAndAnswerOfGame = new String[SIZE_ARRAY_FOR_QUESTIONS_AND_ANSWERS];
        Random random = new Random();
        int number1 = random.nextInt(1, MAX_NUMBER_TO_INTERVAL);
        int number2 = random.nextInt(1, MAX_NUMBER_TO_INTERVAL);
        questionAndAnswerOfGame[INDEX_OF_QUESTION] = number1 + " " + number2;
        questionAndAnswerOfGame[INDEX_OF_CORRECT_ANSWER] = Integer.toString(getGreatestCommonDivisor(number1, number2));
        return questionAndAnswerOfGame;
    }

    public static int getGreatestCommonDivisor(int number1, int number2) {
        int startingValueGreatestCommonDivisor = number1 > number2 ? number2 : number1;

        for (int i = startingValueGreatestCommonDivisor; i > 1; i--) {
            if (number1 % i == 0 && number2 % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
