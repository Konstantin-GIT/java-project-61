package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Arrays;
import java.util.Random;

import static hexlet.code.Engine.engine;

public class Progression {

    private static final String GAME_DESCRIPTION = "What number is missing in the progression?";

    private static final int INDEX_OF_QUESTION = 0;

    private static final int INDEX_OF_CORRECT_ANSWER = 1;

    private static final int SIZE_ARRAY_FOR_QUESTIONS_AND_ANSWERS = 2;

    private static final int MAX_INITIAL_ELEMENT_OF_PROGRESSION = 10;

    private static final int MAX_VALUE_STEP_OF_PROGRESSION = 5;

    private static final int MIN_VALUE_STEP_OF_PROGRESSION = 2;

    private static final int SIZE_OF_PROGRESSION = 10;


    public static void startProgressionGame() {
        String[][] questionsAndAnswersOfGame = getQuestionsAndAnswersOfGame(Engine.NUMBER_OF_ROUNDS);
        engine(GAME_DESCRIPTION, questionsAndAnswersOfGame);
    }

    public static String[][] getQuestionsAndAnswersOfGame(int numberOfRounds)  {
        String[][] questionsAndAnswersOfGame = new String[numberOfRounds][SIZE_ARRAY_FOR_QUESTIONS_AND_ANSWERS];
        Random random = new Random();

        for (int i = 0; i < questionsAndAnswersOfGame.length; i++) {
            String[] progression = getProgression();
            int lengthProgression = progression.length;
            Integer indexHiddenElement = random.nextInt(lengthProgression);
            String expressionForAnswer = progression[indexHiddenElement];
            questionsAndAnswersOfGame[i][INDEX_OF_CORRECT_ANSWER] = expressionForAnswer;
            String[] progressionWithHiddenElement = Arrays.copyOf(progression, lengthProgression);
            progressionWithHiddenElement[indexHiddenElement] = "..";
            String progressionForPrint =  String.join(" ", progressionWithHiddenElement);
            questionsAndAnswersOfGame[i][INDEX_OF_QUESTION] = progressionForPrint;
        }
        return questionsAndAnswersOfGame;
    }

    public static String[] getProgression() {
        String[] progression = new String[SIZE_OF_PROGRESSION];
        Random random = new Random();
        Integer stepForProgression = random.nextInt(MIN_VALUE_STEP_OF_PROGRESSION, MAX_VALUE_STEP_OF_PROGRESSION);
        Integer currentElement = random.nextInt(1, MAX_INITIAL_ELEMENT_OF_PROGRESSION);

        for (int i = 0; i < progression.length; i++) {
            progression[i] = currentElement.toString();
            currentElement = currentElement + stepForProgression;
        }
        return progression;
    }
}
