package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.Engine.engine;

public class Gcd {
    private static final String GAME_DESCRIPTION = "Find the greatest common divisor of given numbers.";

    private static final int INDEX_OF_QUESTION = 0;

    private static final int INDEX_OF_CORRECT_ANSWER = 1;

    private static final int MAX_NUMBER_TO_INTERVAL = 100;

    private static final int SIZE_ARRAY_FOR_QUESTIONS_AND_ANSWERS = 2;

    public static void startGcdGame() {
        String[][] questionsAndAnswersOfGame = getQuestionsAndAnswersOfGame(Engine.NUMBER_OF_ROUNDS);
        engine(GAME_DESCRIPTION, questionsAndAnswersOfGame);
    }

    public static String[][] getQuestionsAndAnswersOfGame(int numberOfRounds)  {
        String[][] questionsAndAnswersOfGame = new String[numberOfRounds][SIZE_ARRAY_FOR_QUESTIONS_AND_ANSWERS];
        Random random = new Random();

        for (int i = 0; i < questionsAndAnswersOfGame.length; i++) {
            int numberOneForQuestion = random.nextInt(1, MAX_NUMBER_TO_INTERVAL);
            int numberTwoForQuestion = random.nextInt(1, MAX_NUMBER_TO_INTERVAL);
            questionsAndAnswersOfGame[i][INDEX_OF_QUESTION] = numberOneForQuestion + " " + numberTwoForQuestion;
            String expressionForAnswer = Integer.toString(getGreatestCommonDivisor(numberOneForQuestion,
                    +numberTwoForQuestion));
            questionsAndAnswersOfGame[i][INDEX_OF_CORRECT_ANSWER] = expressionForAnswer;
        }
        return questionsAndAnswersOfGame;
    }
    public static int getGreatestCommonDivisor(int number1, int number2) {
        int greatestCommonDivisor = number1 > number2 ? number2 : number1;

        for (int i = greatestCommonDivisor; i > 1; i--) {
            if (number1 % i == 0 && number2 % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
