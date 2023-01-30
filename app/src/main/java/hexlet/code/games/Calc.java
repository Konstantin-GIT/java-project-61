package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

import static hexlet.code.Engine.engine;

public class Calc  {

    private static final String GAME_DESCRIPTION = "What is the result of the expression?";

    private static final int INDEX_OF_QUESTION = 0;

    private static final int INDEX_OF_CORRECT_ANSWER = 1;

    private static final int MAX_NUMBER_TO_INTERVAL = 100;

    private static final int SIZE_ARRAY_FOR_QUESTIONS_AND_ANSWERS = 2;

    public static void startCalcGame() throws IncorrectOperationOfMethodExeption {
        String[][] questionsAndAnswersOfGame = getQuestionsAndAnswersOfGame(Engine.NUMBER_OF_ROUNDS);
        engine(GAME_DESCRIPTION, questionsAndAnswersOfGame);
    }

    public static String[][] getQuestionsAndAnswersOfGame(int numberOfRounds)
            throws IncorrectOperationOfMethodExeption {
        String[][] questionsAndAnswersOfGame = new String[numberOfRounds][SIZE_ARRAY_FOR_QUESTIONS_AND_ANSWERS];
        Random random = new Random();
        String[] symbolSet = {"+", "-", "*"};
        for (int i = 0; i < questionsAndAnswersOfGame.length; i++) {
            int numberOneForQuestion = random.nextInt(1, MAX_NUMBER_TO_INTERVAL);
            int numberTwoForQuestion = random.nextInt(1, MAX_NUMBER_TO_INTERVAL);
            String symbol = symbolSet[random.nextInt(symbolSet.length)];
            generateRoundData(numberOneForQuestion, numberTwoForQuestion, symbol);
            questionsAndAnswersOfGame[i] = generateRoundData(numberOneForQuestion, numberTwoForQuestion, symbol);
        }
        return questionsAndAnswersOfGame;
    }

    private static String[] generateRoundData(int number1, int number2, String symbol)
            throws IncorrectOperationOfMethodExeption {
        String[] questionAndAnswerOfGame = new String[SIZE_ARRAY_FOR_QUESTIONS_AND_ANSWERS];
        questionAndAnswerOfGame[INDEX_OF_QUESTION] = number1 + " " + symbol + " " + number2;
        String correctAnswer = Integer.toString(calculate(number1, number2, symbol));
        questionAndAnswerOfGame[INDEX_OF_CORRECT_ANSWER] = correctAnswer;
        return questionAndAnswerOfGame;
    }

    private static int calculate(int number1, int number2, String arithmeticOperator)
            throws IncorrectOperationOfMethodExeption {
        switch (arithmeticOperator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            default:
                throw new IncorrectOperationOfMethodExeption("Incorrect input parameters of the method");
        }
    }

    public static class IncorrectOperationOfMethodExeption extends Exception {

        public IncorrectOperationOfMethodExeption(String message) {
            super(message);
        }
    }
}
