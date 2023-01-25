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

    public static void startCalcGame() {
        String[][] questionsAndAnswersOfGame = Calc.getQuestionsAndAnswersOfGame(Engine.NUMBER_OF_ROUNDS);
        engine(GAME_DESCRIPTION, questionsAndAnswersOfGame);
    }

    public static String[][] getQuestionsAndAnswersOfGame(int numberOfRounds)  {
        String[][] questionsAndAnswersOfGame = new String[numberOfRounds][SIZE_ARRAY_FOR_QUESTIONS_AND_ANSWERS];
        Random random = new Random();
        for (int i = 0; i < questionsAndAnswersOfGame.length; i++) {
            Integer numberOneForQuestion = random.nextInt(1, MAX_NUMBER_TO_INTERVAL);
            Integer numberTwoForQuestion = random.nextInt(1, MAX_NUMBER_TO_INTERVAL);
            String[] symbolSet = {"+", "-", "*"};
            String symbol = symbolSet[random.nextInt(symbolSet.length)];
            questionsAndAnswersOfGame[i][INDEX_OF_QUESTION] = numberOneForQuestion
                    + " " + symbol + " " + numberTwoForQuestion;
            String correctAnswer = "";
            switch (symbol) {
                case "+":
                    correctAnswer = Integer.toString(numberOneForQuestion + numberTwoForQuestion);
                    break;
                case "-":
                    correctAnswer = Integer.toString(numberOneForQuestion - numberTwoForQuestion);
                    break;
                case "*":
                    correctAnswer = Integer.toString(numberOneForQuestion * numberTwoForQuestion);
                    break;
                default: break;
            }
            questionsAndAnswersOfGame[i][INDEX_OF_CORRECT_ANSWER] = correctAnswer;
        }
        return questionsAndAnswersOfGame;
    }
}
