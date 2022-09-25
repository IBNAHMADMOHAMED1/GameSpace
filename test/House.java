import java.util.List;
import java.util.ArrayList;

public class House {
    private List<P> players = new ArrayList<>();
    private List<Game> games = new ArrayList<>();
    private List<Console> consoles = new ArrayList<>();
    private float totalIncome;
    private int workHourStart = 9;
    private int workHourEnd = 20;
    private int workHourPeriod = 11;
    private int workHourNow = 0;
    private int[] hours = { 9, 10, 11, 12, 14, 15, 16, 17, 18, 19, 20 };
    // price per hour

    public void addPlayer(P player) {
        players.add(player);
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public void addConsole(Console console) {
        consoles.add(console);
    }

    public void showPlayer() {
        for (P player : players) {
            // player.printPlayer();
        }
    }

    public void showGame() {
        for (Game game : games) {
            // game.printGame();
        }
    }

    public void showConsole() {
        for (Console console : consoles) {
            // console.printConsole();
        }
    }

    public void showIncome() {
        System.out.println("Total income: " + totalIncome);
    }

    public void showWorkHour() {
        System.out.println("Work hour start: " + workHourStart);
        System.out.println("Work hour end: " + workHourEnd);
        System.out.println("Work hour period: " + workHourPeriod);
    }

    public void showWorkHourNow() {
        System.out.println("Work hour now: " + workHourNow);
    }

    public void showHours() {
        for (int hour : hours) {
            System.out.println(hour);
        }
    }
    
    public void totalIncome() {
        for (Game game : games) {
            totalIncome += game.getPrice();
        }
    }

    
}
