package hexlet.code.games;

import hexlet.code.ConsoleGame;
import java.util.Random;

public class Gcd implements ConsoleGame {
    public final String getRules() {
        return "Find the greatest common divisor of given numbers.";
    }
    public String getQuestionAndCorrectAnswer()  {
        Random random = new Random();
        Integer numberOneForQuestion = random.nextInt(100);
        Integer numberTwoForQuestion = random.nextInt(100);
        System.out.println("Question: " + numberOneForQuestion + " " + numberTwoForQuestion);
        String correctAnswer = String.valueOf(getGreatestCommonDivisor(numberOneForQuestion, numberTwoForQuestion));
        return correctAnswer;
    }
    public static int getGreatestCommonDivisor(Integer number1, Integer number2) {
        int greatestCommonDivisor = number1 > number2 ? number2 : number1;
        for (int i = greatestCommonDivisor; i > 1; i--) {
            if (number1 % i == 0 && number2 % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
