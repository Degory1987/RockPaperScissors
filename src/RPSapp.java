import java.util.Random;
import java.util.Scanner;

public class RPSapp {
    public static void main(String[] args) {
        // Player choice one of:
        System.out.println("Witaj, podaj co wybierasz: 1- kamień, 2 - papier, 3 - nożyce");

        Scanner scanner = new Scanner(System.in);
        int chooseNumb = scanner.nextInt();

        System.out.print("gracz: ");
        metoda(chooseNumb);

        // computer random choice
        Random r = new Random();
        int comNumb = r.nextInt(3);
        System.out.print("komputer: ");
        metoda(comNumb);


        if (chooseNumb == 1 && comNumb == 3 || chooseNumb == 2 && comNumb == 1 || chooseNumb == 3 && comNumb == 2)
            System.out.println("\nWygrałeś");
        if (chooseNumb == 1 && comNumb == 2 || chooseNumb == 2 && comNumb == 3 || chooseNumb == 3 && comNumb == 1)
            System.out.println("\nPrzegrywasz");
        if (chooseNumb == 1 && comNumb == 1 || chooseNumb == 2 && comNumb == 2 || chooseNumb == 3 && comNumb == 3)
            System.out.println("\nremis");

    }


    static int metoda(int n) {

        switch (n) {
            case 1:
                System.out.println("kamień");
                break;
            case 2:
                System.out.println("papier");
                break;
            case 3:
                System.out.println("nożce");
                break;

            default:
        }
        return n;
    }

}
