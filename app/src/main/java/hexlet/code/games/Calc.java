package hexlet.code.games;

import java.util.Random;
import static hexlet.code.Engine.run;

public class Calc  {

    private static final String GAME_DESCRIPTION = "What is the result of the expression?";
    private static final int MAX_NUMBER_TO_INTERVAL = 100;
    private static final int NUMBER_OF_ROUND = 3;

    public static void startCalcGame() {
        String[][] questionsAndAnswersOfGame = new String[NUMBER_OF_ROUND][];
        for (int i = 0; i < questionsAndAnswersOfGame.length; i++) {
            questionsAndAnswersOfGame[i] = generateRoundData();
        }
        run(GAME_DESCRIPTION, questionsAndAnswersOfGame);
    }

    private static String[] generateRoundData() {
        Random random = new Random();
        String[] symbolSet = {"+", "-", "*"};
        String symbol = symbolSet[random.nextInt(symbolSet.length)];
        int number1 = random.nextInt(1, MAX_NUMBER_TO_INTERVAL);
        int number2 = random.nextInt(1, MAX_NUMBER_TO_INTERVAL);
        String question = number1 + " " + symbol + " " + number2;
        String answer = Integer.toString(calculate(number1, number2, symbol));
        return new String[] {question, answer};
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
