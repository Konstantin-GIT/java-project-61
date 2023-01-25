package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.Engine.engine;

public class Calc  {

    private static final String GAME_DESCRIPTION = "What is the result of the expression?";

    public static void startCalcGame() {
        String[][] questionsAndAnswersOfGame = Calc.getQuestionsAndAnswersOfGame(Engine.NUMBER_OF_ROUNDS);
        engine(GAME_DESCRIPTION, questionsAndAnswersOfGame);
    }

    public static String[][] getQuestionsAndAnswersOfGame(int numberOfRounds)  {
        int sizeArrayForQuestionsAndAnswers = 2;
        String[][] questionsAndAnswersOfGame = new String[numberOfRounds][sizeArrayForQuestionsAndAnswers];
        int indexOfQuestion = 0;
        int indexOfCorrectAnswer = 1;
        Random random = new Random();
        int maxNumberToInterval = 100;
        for (int i = 0; i < questionsAndAnswersOfGame.length; i++) {
            Integer numberOneForQuestion = random.nextInt(1, maxNumberToInterval);
            Integer numberTwoForQuestion = random.nextInt(1, maxNumberToInterval);
            String[] symbolSet = {"+", "-", "*"};
            String symbol = symbolSet[random.nextInt(symbolSet.length)];
            questionsAndAnswersOfGame[i][indexOfQuestion] = numberOneForQuestion + " " + symbol + " " + numberTwoForQuestion;
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
            questionsAndAnswersOfGame[i][indexOfCorrectAnswer] = correctAnswer;
        }
        return questionsAndAnswersOfGame;
    }
}
