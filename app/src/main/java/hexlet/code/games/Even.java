package hexlet.code.games;


import hexlet.code.ConsoleGame;

import java.util.Scanner;

public class Even implements ConsoleGame {
    public final String getRules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }
    public String getQuestionAndCorrectAnswer()  {
            Integer numberForQuestion = (int) (Math.random() * 200);
            System.out.println("Question: " + numberForQuestion);
            String correctAnswer = isEven(numberForQuestion) ? "yes" : "no";
            return correctAnswer;

    }
    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

}


