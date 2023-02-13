package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Arrays;
import static hexlet.code.Engine.run;
import static hexlet.code.Utils.generateNumber;

public class Progression {
    private static final String GAME_DESCRIPTION = "What number is missing in the progression?";
    private static final int MAX_INITIAL_ELEMENT_OF_PROGRESSION = 10;
    private static final int MAX_VALUE_STEP_OF_PROGRESSION = 5;
    private static final int MIN_VALUE_STEP_OF_PROGRESSION = 2;
    private static final int SIZE_OF_PROGRESSION = 10;


    public static void startProgressionGame() {
        String[][] roundsData = new String[Engine.NUMBER_OF_ROUNDS][];
        for (int i = 0; i < roundsData.length; i++) {
            roundsData[i] = generateRoundData();
        }
        run(GAME_DESCRIPTION, roundsData);
    }

    private static String[] generateRoundData() {
        int indexHiddenElement = generateNumber(1, SIZE_OF_PROGRESSION - 1);
        int stepProgression = generateNumber(MIN_VALUE_STEP_OF_PROGRESSION, MAX_VALUE_STEP_OF_PROGRESSION);
        int firstNumberProgression = generateNumber(1, MAX_INITIAL_ELEMENT_OF_PROGRESSION);
        String[] progression = getProgression(firstNumberProgression, stepProgression, SIZE_OF_PROGRESSION);
        String answer = progression[indexHiddenElement];
        String[] progressionWithHiddenElement = Arrays.copyOf(progression, progression.length);
        progressionWithHiddenElement[indexHiddenElement] = "..";
        String question = String.join(" ", progressionWithHiddenElement);
        return new String[] {question, answer};
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
