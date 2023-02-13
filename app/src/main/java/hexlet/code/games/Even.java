package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Engine.run;
import static hexlet.code.Utils.generateNumber;

public class Even {

    private static final String GAME_DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MAX_NUMBER_TO_INTERVAL = 100;

    public static void startEvenGame() {
        String[][] roundsData = new String[Engine.NUMBER_OF_ROUNDS][];
        for (int i = 0; i < roundsData.length; i++) {
            roundsData[i] = generateRoundData();
        }
        run(GAME_DESCRIPTION, roundsData);
    }

    private static String[] generateRoundData() {
        int number = generateNumber(1, MAX_NUMBER_TO_INTERVAL);
        String question = Integer.toString(number);
        String answer = isEven(number) ? "yes" : "no";
        return new String[] {question, answer};
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

}


