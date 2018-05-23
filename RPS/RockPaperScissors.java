import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    boolean isRunning = true;

    int limit = 0;
    int total = 0;
    int compWins = 0;
    int playerWins = 0;
    int ties = 0;
    int rock = 0;
    int scissors = 0;
    int paper = 0;
    int randomiser = 0;
    String chosenOne = "";
    String chosenComputer = "";
    private Random rand = new Random();

    Scanner scanner = new Scanner(System.in);

    public void randomise(){
        randomiser = rand.nextInt(99) + 0;
        if (randomiser>33)
        {
            chosenComputer = "Rock";
        }else if (randomiser>66)
        {
            chosenComputer = "Paper";
        }else
        {
            chosenComputer ="Scissors";
        }
    }

    public void result()
    {

        if(chosenOne.equals("Rock")) {
            rock++;
            if (chosenComputer.equals("Rock")) {
                rock++;
                ties++;
                System.out.println("tie");
            }
            if (chosenComputer.equals("Paper")) {
                paper++;
                compWins++;
                System.out.println("computer wins");
            }
            if (chosenComputer.equals("Scissors")) {
                scissors++;
                playerWins++;
                System.out.println("player wins");
            }

        }


        if(chosenOne.equals("Paper"))
        {
                paper++;
                if (chosenComputer.equals("Rock")) {
                    rock++;
                    playerWins++;
                    System.out.println("Player wins");
                }
                if (chosenComputer.equals("Paper")) {
                    paper++;
                    ties++;
                    System.out.println("tie");
                }
                if (chosenComputer.equals("Scissors")) {
                    scissors++;
                    compWins++;
                    System.out.println("computer wins");
                }


        }
        if(chosenOne.equals("Scissors"))
        {
                scissors++;
                if (chosenComputer.equals("Rock")) {
                    rock++;
                    compWins++;
                    System.out.println("computer wins");
                }
                if (chosenComputer.equals("Paper")) {
                    paper++;
                    playerWins++;
                    System.out.println("player wins");
                }
                if (chosenComputer.equals("Scissors")) {
                    scissors++;
                    ties++;
                    System.out.println("tie");
                }

        }
    }


    public void playGame(){
        System.out.println("please enter the number of games you wish to play.");
        limit = scanner.nextInt();
        scanner.nextLine();
        System.out.println("to quit at an earlier game input Quit");
        while (isRunning) {

            System.out.println("Enter some input: (Rock, Paper, Scissors)");
            // User Input i.e.: R/P/S
            chosenOne = scanner.nextLine();
            if (chosenOne.equals("Quit"))
            {
                isRunning=false;
                break;
            }
            System.out.println("");
            randomise();
            System.out.println("The computer chose "+chosenComputer);
            result();
            limit--;
            if (limit==0)
            {isRunning= false;}
            total++;
        }
        if (total >0) {
            int playTotal = (rock + paper + scissors);
            System.out.println("The total games played was: " + total);
            System.out.println("The number of computer wins: " + compWins + " or " + (100.0*compWins / total) + "%");
            System.out.println("The number of player wins: " + playerWins + " or " + (100.0*playerWins / total) + "%");
            System.out.println("The number of draws: " + ties + " or " + (100.0*ties / total) + "%");
            System.out.println("The number of rock played: " + rock + " paper: " + paper + " scissors: " + scissors);
            System.out.println("The percentages for each is rock:" + (100.0*rock / playTotal) + "% paper: " + (100.0*paper / playTotal) + "% scissors: " + (100.0*scissors / playTotal) + "%");
        }else
        {
            System.out.println("The total games played was: 0. No data can be gathered.");
        }
    }

}
