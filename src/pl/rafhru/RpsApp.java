package pl.rafhru;


import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class RpsApp {


    static FileWriter fileResults;

    static {
        try {
            fileResults = new FileWriter("Results.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public RpsApp() {
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Hello!");
        System.out.println("1- game , 2- views results");

        Scanner scanner = new Scanner(System.in);


        int gameMode = scanner.nextInt();
        gameModeChoice(gameMode);

        scanner.close();

    }

    static String playerName;
    static String computer = "Computer ";
    static int playerPoints = 0;
    static int computerPoints = 0;

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

        saveResult(fileResults);
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

    public static void gameModeChoice(int gameMode) throws IOException {
        if (gameMode == 1) {
            System.out.println("Start game!\n");
            onePlayer();
        } else if (gameMode == 2) {
            System.out.println("display results");
            resultsDisplay(fileResults);
        }

    }

    public static void saveResult(FileWriter file) {
        int gameNumber = 1;
        PrintWriter writer = new PrintWriter(file);
        writer.println(gameNumber + ". " + playerName + " " + playerPoints + " : " + computer + " " + computerPoints);
        gameNumber++;
        writer.close();
    }

    public static void resultsDisplay(FileWriter fileResults) throws IOException {
        RpsApp.fileResults = fileResults;

        FileInputStream fileStream = new FileInputStream("Results.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fileStream));

        String strLine;

        //Read File Line By Line
        while ((strLine = br.readLine()) != null) {
            // Print the content on the console
            System.out.println(strLine);
        }
        //Close the input stream
        fileStream.close();


    }
}



