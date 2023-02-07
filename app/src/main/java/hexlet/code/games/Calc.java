package hexlet.code.games;

import java.util.Random;
import static hexlet.code.Engine.run;

public class Calc  {

    private static final String GAME_DESCRIPTION = "What is the result of the expression?";
    private static final int INDEX_OF_QUESTION = 0;
    private static final int INDEX_OF_CORRECT_ANSWER = 1;
    private static final int MAX_NUMBER_TO_INTERVAL = 100;
    private static final int SIZE_ARRAY_FOR_QUESTIONS_AND_ANSWERS = 2;
    private static final int NUMBER_OF_ROUND = 3;

    public static void startCalcGame() {
        String[][] questionsAndAnswersOfGame = new String[NUMBER_OF_ROUND][SIZE_ARRAY_FOR_QUESTIONS_AND_ANSWERS];
        for (int i = 0; i < questionsAndAnswersOfGame.length; i++) {
            questionsAndAnswersOfGame[i] = generateRoundData();
        }
        run(GAME_DESCRIPTION, questionsAndAnswersOfGame);
    }

    private static String[] generateRoundData() {
        String[] questionAndAnswerOfGame = new String[SIZE_ARRAY_FOR_QUESTIONS_AND_ANSWERS];
        Random random = new Random();
        String[] symbolSet = {"+", "-", "*"};
        String symbol = symbolSet[random.nextInt(symbolSet.length)];
        int number1 = random.nextInt(1, MAX_NUMBER_TO_INTERVAL);
        int number2 = random.nextInt(1, MAX_NUMBER_TO_INTERVAL);
        questionAndAnswerOfGame[INDEX_OF_QUESTION] = number1 + " " + symbol + " " + number2;
        String correctAnswer = Integer.toString(calculate(number1, number2, symbol));
        questionAndAnswerOfGame[INDEX_OF_CORRECT_ANSWER] = correctAnswer;
        return questionAndAnswerOfGame;
    }

    private static int calculate(int number1, int number2, String arithmeticOperator) {
        switch (arithmeticOperator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            default:
                throw new RuntimeException("Incorrect input parameters of the method");
        }
    }
}
