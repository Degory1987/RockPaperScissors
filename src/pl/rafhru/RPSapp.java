package pl.rafhru;

import java.util.Random;
import java.util.Scanner;

public class RPSapp {
    public static void main(String[] args) {

        System.out.println("Enter your name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hello! " + name + ".\n");

        String s ;


        do {
            int playerPoints = 0;
            int computerPoints = 0;

            do {
                // Player choice one of:
                System.out.print("Make your choice: 1- ROCK, 2 - PAPER, 3 - SCISSORS \n");
                int chooseNumb = scanner.nextInt();

                System.out.print(name + " ");
                makeChoice(chooseNumb);

                // computer random choice
                Random r = new Random();
                int comNumb = r.nextInt(3) + 1; // Random().nextInt(int bound) = Random integer from 0 (inclusive) to bound (exclusive).// r.nextInt(3) + 1 makes range from 1 to 3.

                System.out.print("Computer ");
                makeChoice(comNumb);


                if (chooseNumb == 1 && comNumb == 3 || chooseNumb == 2 && comNumb == 1 || chooseNumb == 3 && comNumb == 2) {
                    System.out.println("\n" + name + " point for you!");
                    playerPoints++;
                }
                if (chooseNumb == 1 && comNumb == 2 || chooseNumb == 2 && comNumb == 3 || chooseNumb == 3 && comNumb == 1) {
                    System.out.println("\nPoint for computer.");
                    computerPoints++;
                }
                if (chooseNumb == 1 && comNumb == 1 || chooseNumb == 2 && comNumb == 2 || chooseNumb == 3 && comNumb == 3)
                    System.out.println("\nIt's a tie!");

                System.out.println("\nResult:");
                System.out.println(name + " " + playerPoints);
                System.out.println("Computer " + computerPoints + "\n");

            } while (playerPoints < 3 && computerPoints < 3);

            if (playerPoints == 3) {
                System.out.println("\n" + name + " You won!");
            } else {
                System.out.println(name + " you loose:(");
            }

            System.out.println("Do you want to play again? Y/N");
            scanner.nextLine();
            s = scanner.nextLine();

        } while (s.contentEquals("y"));


        System.out.println("Thank you for your game!");
    }



    static void makeChoice(int n) {

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

}
