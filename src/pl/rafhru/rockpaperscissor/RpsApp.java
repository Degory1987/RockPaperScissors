package pl.rafhru.rockpaperscissor;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

import static pl.rafhru.rockpaperscissor.GameHistoryManager.resultsDisplay;

public class RpsApp {

    static FileWriter fileResults;



    static {
        try {
            fileResults = new FileWriter("Results.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
    public static void main(String[] args) throws IOException {
        System.out.println("Hello!");
        System.out.println("1- game , 2- views results");

        Scanner scanner = new Scanner(System.in);

        int gameMode = scanner.nextInt();
        gameModeChoice(gameMode);

        scanner.close();
    }

    public static void gameModeChoice(int gameMode) throws IOException {
        if (gameMode == 1) {
            System.out.println("Start game!\n");
            Player player = new Player();
            player.onePlayer();
        } else if (gameMode == 2) {
            System.out.println("display results");
            resultsDisplay(fileResults);
        }
    }


}



