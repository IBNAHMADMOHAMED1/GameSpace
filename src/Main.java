import java.util.Scanner;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        Scanner scanner = new Scanner(System.in); //Scanner declaration
        Player client = new Player();
        int choice;
        printDesign();
        do {
            System.out.print("1. Create New Player \n");
            System.out.print("2. Show Players \n");
            System.out.print("3. The Waiting Line \n");
            System.out.print("4. Daily Profit \n");
            System.out.print("5. Daily Revenue \n");
            System.out.print("6. Exit \n");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    client.createClient();
                    break;
                case 2:
                    client.showClients();
                    break;
                case 3:
                    client.showLobby();
                    break;
                case 4:
                    System.out.print("total profit: " + client.getProfit() + "\n");
                    break;
                case 5:
                    client.showMonthlyProfit();
                    break;
                case 6:
                    System.out.print("Thank you for using this program \n");
                    break;
            }
        } while (choice != 6);

    }
    public static void printDesign() {
        System.out.println("------------------------------------");
        System.out.println("Welcome to the Game Center");
        System.out.println("------------------------------------");
        System.out.println(" ");
        System.out.println("Please choose one of the following options: \n");
       
    }
}
