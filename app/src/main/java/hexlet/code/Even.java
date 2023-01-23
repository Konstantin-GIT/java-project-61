package hexlet.code;

import java.util.Scanner;

public class Even {

    public static void evenGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("May I have your name?");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        int counter = 0;
        while (counter < 3) {
            Integer numberForQuestion = (int) (Math.random() * 200);
            System.out.println("Question:" + numberForQuestion);
            String answer = scanner.next();
            String correctAnswer = isEven(numberForQuestion) ? "yes" : "no";

            if (answer.equals(correctAnswer)) {
                counter++;
                System.out.println("Correct!");
            } else {
                System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.\n" +
                        "Let's try again, " + userName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }
    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

}


