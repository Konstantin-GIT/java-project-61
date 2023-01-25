package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.Engine.engine;

public class Prime {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void startPrimeGame() {
        String[][] questionsAndAnswersOfGame = Prime.getQuestionsAndAnswersOfGame(Engine.NUMBER_OF_ROUNDS);
        engine(GAME_DESCRIPTION, questionsAndAnswersOfGame);
    }

    public static String[][] getQuestionsAndAnswersOfGame(int numberOfRounds)  {
        int sizeArrayForQuestionsAndAnswers = 2;
        String[][] questionsAndAnswersOfGame = new String[numberOfRounds][sizeArrayForQuestionsAndAnswers];
        int indexOfQuestion = 0;
        int indexOfCorrectAnswer = 1;
        int maxNumberToInterval = 100;
        Random random = new Random();
        for (int i = 0; i < questionsAndAnswersOfGame.length; i++) {
            int expressionForQuestion = random.nextInt(1, maxNumberToInterval);
            questionsAndAnswersOfGame[i][indexOfQuestion] = Integer.toString(expressionForQuestion);
            String expressionFoAnswer = isPrime(expressionForQuestion) ? "yes" : "no";
            questionsAndAnswersOfGame[i][indexOfCorrectAnswer] = expressionFoAnswer;
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
