package hexlet.code.games;

import hexlet.code.ConsoleGame;
import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.Engine.engine;

public class Calc  {

    final static String GAME_DESCRIPTION = "What is the result of the expression?";

    public static void startCalcGame() {
        String[][] questionsAndAnswersOfGame = Calc.getQuestionsAndAnswersOfGame(Engine.numberOfRounds);
        engine(GAME_DESCRIPTION, questionsAndAnswersOfGame);
    }

    public static String[][] getQuestionsAndAnswersOfGame(int numberOfRounds)  {
        int sizeArrayForQuestionsAndAnswers = 2;
        String[][] questionsAndAnswersOfGame = new String[numberOfRounds][sizeArrayForQuestionsAndAnswers];

        for( int i = 0; i < questionsAndAnswersOfGame.length; i++) {
            Random random = new Random();
            Integer numberOneForQuestion = random.nextInt(1,100);
            Integer numberTwoForQuestion = random.nextInt(1,100);
            String[] symbolSet = {"+", "-", "*"};
            String symbol= symbolSet[random.nextInt(symbolSet.length)];
            String question = questionsAndAnswersOfGame[i][0] = Integer.toString(numberOneForQuestion) + " " + symbol + " " + Integer.toString(numberTwoForQuestion);
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
            }
            String answer = questionsAndAnswersOfGame[i][1] = correctAnswer;
        }
        return questionsAndAnswersOfGame;
    }
}
