package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import static hexlet.code.Engine.run;

public class Gcd {
    private static final String GAME_DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final int MAX_NUMBER_TO_INTERVAL = 100;

    public static void startGcdGame() {
        String[][] questionsAndAnswersOfGame = new String[Engine.NUMBER_OF_ROUNDS][];
        for (int i = 0; i < questionsAndAnswersOfGame.length; i++) {
            questionsAndAnswersOfGame[i] = generateRoundData();
        }
        run(GAME_DESCRIPTION, questionsAndAnswersOfGame);
    }

    private static String[] generateRoundData() {
        Random random = new Random();
        int number1 = random.nextInt(1, MAX_NUMBER_TO_INTERVAL);
        int number2 = random.nextInt(1, MAX_NUMBER_TO_INTERVAL);
        String question = number1 + " " + number2;
        String answer = Integer.toString(getGreatestCommonDivisor(number1, number2));
        return new String[] {question, answer};
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
