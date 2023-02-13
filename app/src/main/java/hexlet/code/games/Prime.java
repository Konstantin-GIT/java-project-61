package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Engine.run;
import static hexlet.code.Utils.generateNumber;

public class Prime {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MAX_NUMBER_TO_INTERVAL = 100;

    public static void startPrimeGame() {
        String[][] roundsData = new String[Engine.NUMBER_OF_ROUNDS][];
        for (int i = 0; i < roundsData.length; i++) {
            roundsData[i] = generateRoundData();
        }
        run(GAME_DESCRIPTION, roundsData);
    }

    private static String[] generateRoundData() {
        int number = generateNumber(1, MAX_NUMBER_TO_INTERVAL);
        String question = Integer.toString(number);
        String answer = isPrime(number) ? "yes" : "no";
        return new String[] {question, answer};
    }

    public static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
