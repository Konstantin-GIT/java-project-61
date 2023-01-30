package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.Engine.engine;

public class Prime {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static final int INDEX_OF_QUESTION = 0;

    private static final int INDEX_OF_CORRECT_ANSWER = 1;

    private static final int MAX_NUMBER_TO_INTERVAL = 100;

    private static final int SIZE_ARRAY_FOR_QUESTIONS_AND_ANSWERS = 2;

    public static void startPrimeGame() {
        String[][] questionsAndAnswersOfGame = Prime.getQuestionsAndAnswersOfGame(Engine.NUMBER_OF_ROUNDS);
        engine(GAME_DESCRIPTION, questionsAndAnswersOfGame);
    }

    public static String[][] getQuestionsAndAnswersOfGame(int numberOfRounds)  {
        String[][] questionsAndAnswersOfGame = new String[numberOfRounds][SIZE_ARRAY_FOR_QUESTIONS_AND_ANSWERS];
        Random random = new Random();

        for (int i = 0; i < questionsAndAnswersOfGame.length; i++) {
            int expressionForQuestion = random.nextInt(1, MAX_NUMBER_TO_INTERVAL);
            questionsAndAnswersOfGame[i][INDEX_OF_QUESTION] = Integer.toString(expressionForQuestion);
            String expressionForAnswer = isPrime(expressionForQuestion) ? "yes" : "no";
            questionsAndAnswersOfGame[i][INDEX_OF_CORRECT_ANSWER] = expressionForAnswer;
        }
        return questionsAndAnswersOfGame;
    }
    public static boolean isPrime(int number) {
        for (int i = number / 2; i > 1; i--) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
