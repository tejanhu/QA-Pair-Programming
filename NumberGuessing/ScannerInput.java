import java.util.Scanner;

public class ScannerInput {
    public static void getInputs() {
        Scanner scanner = new Scanner(System.in);
        int guess = (int) (Math.random() * 100);
        int max = 100;
        int min = 0;
        int turns = 0;
        boolean win = false;
        String higherOrLower;

        System.out.println("Think of  number between 0 and 100");
        System.out.println();
        System.out.println("Is it " + guess + "?");

        while (!win) {
            turns++;
            System.out.println("Higher/Lower/Correct (H/L/C)");
            higherOrLower = scanner.nextLine();
            if (higherOrLower.equals("C")) {
                win = true;
                System.out.println("I guessed it... It was " + guess + "!");
                if (turns==1) {
                    System.out.println("And I got it on the first try!");
                } else {
                    System.out.println("And it only took me " + turns + " guesses!");
                }
            } else if (higherOrLower.equals("L") || higherOrLower.equals("H")) {
                if (higherOrLower.equals("H")) {
                    min = guess + 1;
                    guess = compGuess(max, min);
                    System.out.println("Is it " + guess + "?");
                } else if (higherOrLower.equals("L")) {
                    max = guess - 1;
                    guess = compGuess(max, min);
                    System.out.println("Is it " + guess + "?");
                }
            }
        }
    }

    public static int compGuess(int max, int min) {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }
}
