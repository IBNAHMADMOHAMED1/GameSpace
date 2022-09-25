import java.util.Scanner;

public class Menu {


    public static void mainMenu() {
        Scanner input = new Scanner(System.in);
        int menu = 0;
        do {
            System.out.println("1. Add Player");
            System.out.println("2. Add Game");
            System.out.println("3. Show Player");
            System.out.println("4. Show Game");
            System.out.println("5. Exit");
            System.out.print("Choose menu: ");
            menu = input.nextInt();
            switch (menu) {
                case 1:
                    addPlayer();
                    break;
                case 2:
                    // addGame();
                    break;
                case 3:
                    // showPlayer();
                    break;
                case 4:
                    // showGame();
                    break;
                case 5:
                    System.out.println("Thank you for using this program");
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        } while (menu != 5);
    }

    public static void showGame() {

    }

    public static void showPlayer() {

    }

    public static void addGame() {

    }

    public static void addPlayer() {
        boolean available;
        String screen = "";
        Scanner input = new Scanner(System.in);
        System.out.print("Input player name: ");
        String name = input.nextLine();

        String console = menuConsole();
        System.out.print("Your choice is:" + console+"\n");
        int place = menuPlace();
        System.out.println("You have chosen " + console + " and " + place);
        // System.out.print("Waiting check is available or not...");
        // ask if want to chose a screen
        System.out.print("Do you want to choose a screen? (y/n): ");
        String chooseScreen = input.nextLine();
        if (chooseScreen.equals("y")) {
             screen = menuScreen();
            System.out.println("You have chosen Screen " + screen + " and Place " + place + " for " + console);
            System.out.println("Waiting check is available or not...");
             available = checkAvailable(place, screen);

        } else if (chooseScreen.equals("n")) {
            System.out.println("You have chosen no screen");
            System.out.println("You have chosen " + console + " and " + place);
            
            System.out.println("Waiting check is available or not...");
            // available = checkAvailable(place, console);
            P player = new P(name);
            Game game = new Game(console, screen, place, 14, 20, player);
            game.storeGame(console, place, screen, 14, 20, game.getPrice());
            game.getAllGame();

         } else {
             available = false;
             System.out.println("Wrong input");
         }
        //  if (available) {
        //      System.out.println("Available");
        //     //  int time = menuTimeGame(console, place, screen);
        //      Player player = new Player(name);
        //      Game game = new Game(console, screen, place,14, 20, player);

        //  }
         
            

    }

    public static String menuConsole() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Choose which console you want to play");
            Console[] consoles = Console.values();
            for (int i = 0; i < consoles.length; i++) {
                System.out.println((i + 1) + ". " + consoles[i]);
            }
            int console = input.nextInt();
            switch (console) {
                case 1:
                    return "XBOX";
                case 2:
                    return "PLAYSTATION5";
                case 3:
                    return "NINTENDOSWITCH";
                default:
                    System.out.println("Wrong input");
                    break;
            }
        } while (true);
    }

    public static int menuPlace() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("1. Place 1");
            System.out.println("2. Place 2");
            System.out.println("3. Place 3");
            System.out.println("4. Place 4");
            System.out.println("5. Place 5");
            System.out.println("6. Place 6");
            System.out.println("7. Place 7");
            System.out.println("8. Place 8");
            System.out.println("9. Place 9");
            System.out.print("Choose place: ");
            int place = input.nextInt();
            switch (place) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case 7:
                    return 7;
                case 8:
                    return 8;
                case 9:
                    return 9;
                case 10:
                    return 10;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        } while (true);
    }

    public static String menuScreen() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Which screen do you want to choose?");
            Screen[] screens = Screen.values();
            for (int i = 0; i < screens.length; i++) {
                System.out.println((i + 1) + ". " + screens[i]);
            }
            int screen = input.nextInt();
            System.out.print("Choose screen: ");
            for (int i = 0; i < screens.length; i++) {
                if (screen == i + 1) {
                    return screens[i].toString();
                }
            }

        } while (true);
    }

    /**
     * @param place
     * @param screens
     * @return
     */
    public static boolean checkAvailable(int place, String... args) {
        // String screen = args[0];
        // boolean available = false;
        // String console = "";
        // if (args.length >= 1) {
        //     console = args[1];
        // }
        // System.out.println("Checking..." + console + " ");
        return true;

    }
    
//    public static int menuTimeGame(String console, int place, String screen) {
//         Scanner input = new Scanner(System.in);
//         do {
//             System.out.println("which time do you want to start?");
//             System.out.println("1. 10:00");
//         } while (true);
//         return input.nextInt();
    
            
        
//     }
}
    