package hexlet.code.games;

import hexlet.code.ConsoleGame;

import java.util.Arrays;
import java.util.Random;

public class Progression implements ConsoleGame {
    public final String getRules() {
        return "Please enter the game number and press Enter.";
    }
    public String getQuestionAndCorrectAnswer()  {
        String[] progression = getProgression();
        int lengthProgression = progression.length;
        Random random = new Random();
        Integer indexHiddenElement = random.nextInt(lengthProgression);
        String correctAnswer = progression[indexHiddenElement];
        String[]  progressionWithHiddenElement = Arrays.copyOf(progression, lengthProgression);
        progressionWithHiddenElement[indexHiddenElement] = "..";
        String progressionForPrint =  String.join(" ", progressionWithHiddenElement);
        System.out.println("Question: " + progressionForPrint);
        return correctAnswer;
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
