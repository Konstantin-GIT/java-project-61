package hexlet.code.games;

import hexlet.code.consoleGame;

import java.util.Arrays;
import java.util.Random;

public class Calc implements consoleGame {
        public final String getRules() {
            return "What is the result of the expression?";
        }
        public String getQuestionAndCorrectAnswer()  {
            Random random = new Random();
            Integer numberOneForQuestion = random.nextInt(100);
            Integer numberTwoForQuestion = random.nextInt(100);
            String[] symbolSet = {"+", "-", "*"};
            String symbol= symbolSet[random.nextInt(symbolSet.length)];
            System.out.println("Question: " + numberOneForQuestion + symbol + numberTwoForQuestion);

            String correctAnswer = "";
            switch (symbol) {
                case "+":
                    correctAnswer = Integer.toString(numberOneForQuestion + numberTwoForQuestion);
                    break;
                case "-":
                    correctAnswer = Integer.toString(numberOneForQuestion - numberTwoForQuestion);
                    break;
                case "*":
                    correctAnswer = Integer.toString(numberOneForQuestion * numberTwoForQuestion);
                    break;
            }
        return correctAnswer;
    }
}
