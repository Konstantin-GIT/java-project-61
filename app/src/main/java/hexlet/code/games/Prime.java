package hexlet.code.games;

import hexlet.code.ConsoleGame;

import java.util.Random;

public class Prime implements ConsoleGame {
    public final String getRules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }
    public String getQuestionAndCorrectAnswer()  {
        Random random = new Random();
        Integer numberForQuestion = random.nextInt(1,100);
        System.out.println("Question: " + numberForQuestion);
        String correctAnswer = isPrime(numberForQuestion) ? "yes" : "no";
        return correctAnswer;
    }
    public static boolean isPrime(int number) {
        for (int i = number / 2; i > 1; i--) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
