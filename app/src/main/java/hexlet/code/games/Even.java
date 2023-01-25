package hexlet.code.games;


import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.Engine.engine;

public class Even {

    final static String GAME_DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void startEvenGame() {
        String[][] questionsAndAnswersOfGame = Even.getQuestionsAndAnswersOfGame(Engine.NUMBER_OF_ROUNDS);
        engine(GAME_DESCRIPTION, questionsAndAnswersOfGame);
    }

    public static String[][] getQuestionsAndAnswersOfGame(int numberOfRounds)  {
        int sizeArrayForQuestionsAndAnswers = 2;
        String[][] questionsAndAnswersOfGame = new String[numberOfRounds][sizeArrayForQuestionsAndAnswers];
        int indexOfQuestion = 0;
        int indexOfCorrectAnswer = 1;
        Random random = new Random();
        for( int i = 0; i < questionsAndAnswersOfGame.length; i++) {
            int expressionForQuestion = random.nextInt(1,100);
            String question = questionsAndAnswersOfGame[i][indexOfQuestion] = Integer.toString(expressionForQuestion);
            String expressionFoAnswer = isEven(expressionForQuestion) ? "yes" : "no";
            String answer = questionsAndAnswersOfGame[i][indexOfCorrectAnswer] = expressionFoAnswer;
        }
            return questionsAndAnswersOfGame;
    }
    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

}


