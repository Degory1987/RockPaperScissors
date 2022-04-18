package pl.rafhru.rockpaperscissor;

import java.io.*;
import java.util.Scanner;

import static pl.rafhru.rockpaperscissor.GameHistoryManager.fileResults;
import static pl.rafhru.rockpaperscissor.GameHistoryManager.resultsDisplay;

public class RpsApp {


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



