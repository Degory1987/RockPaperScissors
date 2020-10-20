import java.util.Random;
import java.util.Scanner;

public class RPSapp {
    public static void main(String[] args) {
        // Player choice one of:
        System.out.println("Hello! Make your choice: 1- ROKC, 2 - PAPER, 3 - SCISSORS");

        Scanner scanner = new Scanner(System.in);
        int chooseNumb = scanner.nextInt();

        System.out.print("Player: ");
        makeChoice(chooseNumb);

        // computer random choice
        Random r = new Random();
        int comNumb = r.nextInt(3);
        System.out.print("Computer: ");
        makeChoice(comNumb);


        if (chooseNumb == 1 && comNumb == 3 || chooseNumb == 2 && comNumb == 1 || chooseNumb == 3 && comNumb == 2)
            System.out.println("\nYou won!");
        if (chooseNumb == 1 && comNumb == 2 || chooseNumb == 2 && comNumb == 3 || chooseNumb == 3 && comNumb == 1)
            System.out.println("\nYou loose.");
        if (chooseNumb == 1 && comNumb == 1 || chooseNumb == 2 && comNumb == 2 || chooseNumb == 3 && comNumb == 3)
            System.out.println("\nTie.");

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
                System.out.println("SCISSORS");
                break;

            default:
        }
    }

}
