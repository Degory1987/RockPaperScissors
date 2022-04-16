package pl.rafhru.rockpaperscissor;

import java.io.*;

import static pl.rafhru.rockpaperscissor.ComputerPlayer.computer;
import static pl.rafhru.rockpaperscissor.ComputerPlayer.computerPoints;
import static pl.rafhru.rockpaperscissor.Player.*;

public class GameHistoryManager {

    public static void saveResult(FileWriter file) {
        int gameNumber = 1;
        PrintWriter writer = new PrintWriter(file);
        writer.println(gameNumber + ". " + getPlayerName() + " " + getPlayerPoints() + " : " + computer + " " + computerPoints);
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
