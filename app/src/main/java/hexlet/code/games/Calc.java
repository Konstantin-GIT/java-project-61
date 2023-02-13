package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Engine.run;
import static hexlet.code.Utils.generateNumber;

public class Calc  {
    private static String[] symbolSet = {"+", "-", "*"};
    private static final String GAME_DESCRIPTION = "What is the result of the expression?";
    private static final int MAX_NUMBER_TO_INTERVAL = 100;

    public static void startCalcGame() {
        String[][] roundsData = new String[Engine.NUMBER_OF_ROUNDS][];
        for (int i = 0; i < roundsData.length; i++) {
            roundsData[i] = generateRoundData();
        }
        run(GAME_DESCRIPTION, roundsData);
    }

    private static String[] generateRoundData() {
        String symbol = symbolSet[generateNumber(0, symbolSet.length - 1)];
        int number1 = generateNumber(1, MAX_NUMBER_TO_INTERVAL);
        int number2 = generateNumber(1, MAX_NUMBER_TO_INTERVAL);
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
