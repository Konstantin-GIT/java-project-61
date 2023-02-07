package hexlet.code.games;

import java.util.Arrays;
import java.util.Random;
import static hexlet.code.Engine.run;

public class Progression {

    private static final String GAME_DESCRIPTION = "What number is missing in the progression?";
    private static final int INDEX_OF_QUESTION = 0;
    private static final int INDEX_OF_CORRECT_ANSWER = 1;
    private static final int SIZE_ARRAY_FOR_QUESTIONS_AND_ANSWERS = 2;
    private static final int MAX_INITIAL_ELEMENT_OF_PROGRESSION = 10;
    private static final int MAX_VALUE_STEP_OF_PROGRESSION = 5;
    private static final int MIN_VALUE_STEP_OF_PROGRESSION = 2;
    private static final int SIZE_OF_PROGRESSION = 10;
    private static final int NUMBER_OF_ROUND = 3;


    public static void startProgressionGame() {
        String[][] questionsAndAnswersOfGame = new String[NUMBER_OF_ROUND][SIZE_ARRAY_FOR_QUESTIONS_AND_ANSWERS];
        for (int i = 0; i < questionsAndAnswersOfGame.length; i++) {
            questionsAndAnswersOfGame[i] = generateRoundData();
        }
        run(GAME_DESCRIPTION, questionsAndAnswersOfGame);
    }

    private static String[] generateRoundData() {
        String[] questionAndAnswerOfGame = new String[SIZE_ARRAY_FOR_QUESTIONS_AND_ANSWERS];
        Random random = new Random();
        int indexHiddenElement = random.nextInt(SIZE_OF_PROGRESSION);
        int stepProgression = random.nextInt(MIN_VALUE_STEP_OF_PROGRESSION, MAX_VALUE_STEP_OF_PROGRESSION);
        int firstNumberProgression = random.nextInt(1, MAX_INITIAL_ELEMENT_OF_PROGRESSION);
        String[] progression = getProgression(firstNumberProgression, stepProgression, SIZE_OF_PROGRESSION);
        questionAndAnswerOfGame[INDEX_OF_CORRECT_ANSWER] = progression[indexHiddenElement];
        String[] progressionWithHiddenElement = Arrays.copyOf(progression, progression.length);
        progressionWithHiddenElement[indexHiddenElement] = "..";
        questionAndAnswerOfGame[INDEX_OF_QUESTION] = String.join(" ", progressionWithHiddenElement);
        return questionAndAnswerOfGame;
    }

    public static String[] getProgression(int firstNumberProgression, int stepProgression, int lengthProgression) {
        String[] progression = new String[lengthProgression];
        int currentElement = firstNumberProgression;
        for (int i = 0; i < lengthProgression; i++) {
            progression[i] = Integer.toString(currentElement);
            currentElement = currentElement + stepProgression;
        }
        return progression;
    }
}
