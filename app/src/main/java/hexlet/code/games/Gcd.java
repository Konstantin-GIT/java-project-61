package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.Engine.engine;

public class Gcd {
    private static final String GAME_DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public static void startGcdGame() {
        String[][] questionsAndAnswersOfGame = Gcd.getQuestionsAndAnswersOfGame(Engine.NUMBER_OF_ROUNDS);
        engine(GAME_DESCRIPTION, questionsAndAnswersOfGame);
    }

    public static String[][] getQuestionsAndAnswersOfGame(int numberOfRounds)  {
        int sizeArrayForQuestionsAndAnswers = 2;
        String[][] questionsAndAnswersOfGame = new String[numberOfRounds][sizeArrayForQuestionsAndAnswers];
        Random random = new Random();
        int indexOfQuestion = 0;
        int indexOfCorrectAnswer = 1;
        int maxNumberToInterval = 100;
        for (int i = 0; i < questionsAndAnswersOfGame.length; i++) {
            Integer numberOneForQuestion = random.nextInt(1, maxNumberToInterval);
            Integer numberTwoForQuestion = random.nextInt(1, maxNumberToInterval);
            questionsAndAnswersOfGame[i][indexOfQuestion] = numberOneForQuestion + " " + numberTwoForQuestion;
            String expressionFoAnswer = Integer.toString(getGreatestCommonDivisor(numberOneForQuestion, numberTwoForQuestion));
            questionsAndAnswersOfGame[i][indexOfCorrectAnswer] = expressionFoAnswer;
        }
        return questionsAndAnswersOfGame;
    }
    public static Integer getGreatestCommonDivisor(Integer number1, Integer number2) {
        int greatestCommonDivisor = number1 > number2 ? number2 : number1;
        for (int i = greatestCommonDivisor; i > 1; i--) {
            if (number1 % i == 0 && number2 % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
