import java.util.List;
import java.util.ArrayList;

public class TimeGame {
    private String console;
    private int place;
    private int idGame;
    private int[] hours = { 9, 10, 11, 12, 14, 15, 16, 17, 18, 19, 20 };

    public TimeGame(String console, int place) {
        this.console = console;
        this.place = place;
    }
    // create method to add game to array of hours
    public void addGame(int hour ) {
        // create table of console and place and add game to it
        if (this.console == "Xbox" && this.place == 1) {
            // add game to array of hours
            addGame(hour);
        }



    }
}
