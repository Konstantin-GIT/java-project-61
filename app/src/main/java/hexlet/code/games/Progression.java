package hexlet.code.games;

import hexlet.code.ConsoleGame;
import hexlet.code.Engine;

import java.util.Arrays;
import java.util.Random;

import static hexlet.code.Engine.engine;

public class Progression {
    final static String GAME_DESCRIPTION = "What number is missing in the progression?";

    public static void startProgressionGame() {
        String[][] questionsAndAnswersOfGame = Progression.getQuestionsAndAnswersOfGame(Engine.numberOfRounds);
        engine(GAME_DESCRIPTION, questionsAndAnswersOfGame);
    }

    public static String[][] getQuestionsAndAnswersOfGame(int numberOfRounds)  {
        int sizeArrayForQuestionsAndAnswers = 2;
        String[][] questionsAndAnswersOfGame = new String[numberOfRounds][sizeArrayForQuestionsAndAnswers];
        Random random = new Random();
        int indexOfQuestion = 0;
        int indexOfCorrectAnswer = 1;
        for( int i = 0; i < questionsAndAnswersOfGame.length; i++) {
            String[] progression = getProgression();
            int lengthProgression = progression.length;
            Integer indexHiddenElement = random.nextInt(lengthProgression);
            String expressionForAnswer = progression[indexHiddenElement];
            String answer = questionsAndAnswersOfGame[i][indexOfCorrectAnswer] = expressionForAnswer;
            String[]  progressionWithHiddenElement = Arrays.copyOf(progression, lengthProgression);
            progressionWithHiddenElement[indexHiddenElement] = "..";
            String progressionForPrint =  String.join(" ", progressionWithHiddenElement);
            String question = questionsAndAnswersOfGame[i][indexOfQuestion] = progressionForPrint;
        }
        return questionsAndAnswersOfGame;
    }
    public static String[] getProgression() {
        String[] progression = new String[10];
        Random random = new Random();
        Integer stepForProgression = random.nextInt(2,5);
        Integer currentElement = random.nextInt(1,10);
        for (int i = 0; i < progression.length; i++) {
            progression[i] = currentElement.toString();
            currentElement = currentElement + stepForProgression;
        }
        return progression;
    }


}
