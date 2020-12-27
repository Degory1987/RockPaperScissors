package pl.rafhru;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RpsApp {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Hello!");
        System.out.println("1- game , 2- views results");

        Scanner scanner = new Scanner(System.in);
        File file = new File("Results.txt");
        Scanner scFile = new Scanner(file);
        int gameMode = scanner.nextInt();
        gameModeChoice(gameMode);

        scanner.close();

//        saveResult(file);
//        resultsDisplay(scFile);

    }

    static String playerName;
    static String computer = "Computer ";

    public static void onePlayer() throws InputMismatchException {

        String rematch;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter your name: ");
            playerName = scanner.nextLine();
            int playerPoints = 0;
            int computerPoints = 0;

            do {

                System.out.print("Make your choice: 1- ROCK, 2 - PAPER, 3 - SCISSORS \n");

                int chooseNumb = scanner.nextInt();

                if (chooseNumb < 1 || chooseNumb > 3) {
                    System.out.println("please choose again");
                } else {

                    System.out.print(playerName + " ");
                    makeChoice(chooseNumb);

                    // computer random choice
                    Random r = new Random();
                    int comNumb = r.nextInt(3) + 1; // Random().nextInt(int bound) = Random integer from 0 (inclusive) to bound (exclusive).// r.nextInt(3) + 1 makes range from 1 to 3.

                    System.out.print(computer);
                    makeChoice(comNumb);

                    if (chooseNumb == 1 && comNumb == 3 || chooseNumb == 2 && comNumb == 1 || chooseNumb == 3 && comNumb == 2) {
                        System.out.println("\n" + playerName + " point for you!");
                        playerPoints++;
                    }
                    if (chooseNumb == 1 && comNumb == 2 || chooseNumb == 2 && comNumb == 3 || chooseNumb == 3 && comNumb == 1) {
                        System.out.println("\nPoint for " + computer);
                        computerPoints++;
                    }
                    if (chooseNumb == 1 && comNumb == 1 || chooseNumb == 2 && comNumb == 2 || chooseNumb == 3 && comNumb == 3) {
                        System.out.println("\nIt's a tie!");

                    }
                    System.out.println("\nResult:");
                    System.out.println(playerName + " " + playerPoints);
                    System.out.println(computer + " " + computerPoints + "\n");
                }

            }
            while (playerPoints < 3 && computerPoints < 3);

            if (playerPoints == 3) {
                System.out.println("\n" + playerName + " You won!");
            } else {
                System.out.println(playerName + " you loose:(");
            }

            System.out.println("Do you want to play again? Y/N");
            scanner.nextLine();
            rematch = scanner.nextLine();

        } while ("y".contentEquals(rematch));

        System.out.println("Thank you for your game!");
        scanner.close();

    }

    public static void makeChoice(int n) {

        switch (n) {
            case 1:
                System.out.println("ROCK!");
                break;
            case 2:
                System.out.println("PAPER!");
                break;
            case 3:
                System.out.println("SCISSORS!");
                break;

            default:
        }
    }

    public static void gameModeChoice(int gameMode) {
        if (gameMode == 1) {
            System.out.println("Start game!\n");
            onePlayer();
        } else if (gameMode == 2) {
            System.out.println("display results");

        }

    }

/*

 public static void Results () {

     File file = new File("Results");


 }
 //need to change it. It has to save game results in file.
 public static void saveResult (File file) throws FileNotFoundException {
     PrintWriter writer = new PrintWriter(file);
     writer.println(p1Name + " " + playerPoints + " : " + computer + " " + computerPoints);
     writer.close();
 }

 public static void resultsDisplay (Scanner scanner){
     while (scanner.hasNext()) {
         String line = scanner.nextLine();
         System.out.println(line);
     }
*/

}



