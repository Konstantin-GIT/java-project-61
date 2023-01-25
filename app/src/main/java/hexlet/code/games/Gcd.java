package hexlet.code.games;

import hexlet.code.ConsoleGame;
import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.Engine.engine;

public class Gcd {
    final static String GAME_DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void startGcdGame() {
        String[][] questionsAndAnswersOfGame = Prime.getQuestionsAndAnswersOfGame(Engine.numberOfRounds);
        engine(GAME_DESCRIPTION, questionsAndAnswersOfGame);
    }

    public static String[][] getQuestionsAndAnswersOfGame(int numberOfRounds)  {
        int sizeArrayForQuestionsAndAnswers = 2;
        String[][] questionsAndAnswersOfGame = new String[numberOfRounds][sizeArrayForQuestionsAndAnswers];
        Random random = new Random();
        int indexOfQuestion = 0;
        int indexOfCorrectAnswer = 1;
        for( int i = 0; i < questionsAndAnswersOfGame.length; i++) {
            Integer numberOneForQuestion = random.nextInt(100);
            Integer numberTwoForQuestion = random.nextInt(100);
            String question = questionsAndAnswersOfGame[i][indexOfQuestion] = Integer.toString(numberOneForQuestion) + " " + Integer.toString(numberTwoForQuestion);
            String expressionFoAnswer = Integer.toString(getGreatestCommonDivisor(numberOneForQuestion, numberTwoForQuestion));
            String answer = questionsAndAnswersOfGame[i][indexOfCorrectAnswer] = expressionFoAnswer;
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
