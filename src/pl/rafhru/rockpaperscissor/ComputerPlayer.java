package pl.rafhru.rockpaperscissor;

public class ComputerPlayer {

    static String computer = "Computer ";
    static int computerPoints = 0;

    public static String getComputer() {
        return computer;
    }

    public static void setComputerPoints(int computerPoints) {
        ComputerPlayer.computerPoints = computerPoints;
    }

    public static int getComputerPoints() {
        return computerPoints;
    }
}
