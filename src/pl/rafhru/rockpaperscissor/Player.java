package pl.rafhru.rockpaperscissor;

import java.util.Random;
import java.util.Scanner;

import static pl.rafhru.rockpaperscissor.ComputerPlayer.*;
import static pl.rafhru.rockpaperscissor.GameHistoryManager.fileResults;

public class Player {

    private static String playerName;
    private static int playerPoints = 0;

    public static void onePlayer() {

        String rematch;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter your name: ");
            playerName = scanner.nextLine();

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
                        setComputerPoints(computerPoints++);
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

        GameHistoryManager.saveResult(fileResults);
        System.out.println("Thank you for your game!");
        scanner.close();

    }

    public static void makeChoice(int n) {

        switch (n) {
            case 1 -> System.out.println("ROCK!");
            case 2 -> System.out.println("PAPER!");
            case 3 -> System.out.println("SCISSORS!");
            default -> {
            }
        }
    }

    public static String getPlayerName() {
        return playerName;
    }

    public static int getPlayerPoints() {
        return playerPoints;
    }
}
