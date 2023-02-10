package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import static hexlet.code.Engine.run;

public class Even {

    private static final String GAME_DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MAX_NUMBER_TO_INTERVAL = 100;

    public static void startEvenGame() {
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
        String answer = isEven(number) ? "yes" : "no";
        return new String[] {question, answer};
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

}


