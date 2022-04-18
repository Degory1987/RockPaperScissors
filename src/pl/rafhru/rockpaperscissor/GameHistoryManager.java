package pl.rafhru.rockpaperscissor;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import static pl.rafhru.rockpaperscissor.ComputerPlayer.computer;
import static pl.rafhru.rockpaperscissor.ComputerPlayer.computerPoints;
import static pl.rafhru.rockpaperscissor.Player.*;

public class GameHistoryManager {

    public static void saveResult(FileWriter file) {
        int gameNumber = 1;
        PrintWriter writer = new PrintWriter(file);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        writer.println(gameNumber + ". " + getPlayerName() + " " + getPlayerPoints() + " : " + computer + " " + computerPoints + "; date: " + simpleDateFormat.format(date));
        gameNumber++;//TODO it's not work, don't increments games number.
        writer.close();
    }

    static FileWriter fileResults;

    static {
        try {
            fileResults = new FileWriter("Results.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void resultsDisplay(FileWriter fileResults) throws IOException {
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
