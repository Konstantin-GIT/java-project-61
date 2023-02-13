package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Engine.run;
import static hexlet.code.Utils.generateNumber;

public class Gcd {
    private static final String GAME_DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final int MAX_NUMBER_TO_INTERVAL = 100;

    public static void startGcdGame() {
        String[][] roundsData = new String[Engine.NUMBER_OF_ROUNDS][];
        for (int i = 0; i < roundsData.length; i++) {
            roundsData[i] = generateRoundData();
        }
        run(GAME_DESCRIPTION, roundsData);
    }

    private static String[] generateRoundData() {
        int number1 = generateNumber(1, MAX_NUMBER_TO_INTERVAL);
        int number2 = generateNumber(1, MAX_NUMBER_TO_INTERVAL);
        String question = number1 + " " + number2;
        String answer = Integer.toString(gcd(number1, number2));
        return new String[] {question, answer};
    }

    public static int gcd(int number1, int number2) {
        int startingValueGreatestCommonDivisor = number1 > number2 ? number2 : number1;

        for (int i = startingValueGreatestCommonDivisor; i > 1; i--) {
            if (number1 % i == 0 && number2 % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
