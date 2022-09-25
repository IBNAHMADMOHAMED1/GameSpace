import java.util.ArrayList;

public class Game {
    private String nameGame;
    private int idGame;
    private int startHour;
    private int endHour;
    private int timePeriod;
    private P player;
    private int startedTime;
    private int price;
    private String screen;
    private static ArrayList<Object> listGame = new ArrayList<Object>();
    private double time[] = { 9, 9.5, 10, 10.5, 11, 11.5, 12, 12.5, 14, 14.5, 15, 15.5, 16, 16.5, 17, 17.5, 18, 18.5, 19, 19.5, 20 };

    
    
    public Game(String console, String screen, int place, int startHour, int endHour, P player) {
        this.startHour = startHour;
        this.endHour = endHour;
        this.timePeriod = endHour - startHour;
        this.screen = screen;
        storeGame(console, place, screen, startHour, endHour, getPrice());
    }
    
    public static ArrayList<Object> getListGame() {
        return listGame;
    }

    public static void setListGame(ArrayList<Object> listGame) {
        Game.listGame = listGame;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public int getPrice() {

        switch (this.timePeriod) {
            case 30:
              return  this.price = 5;
                
            case 1:
                return this.price = 10;
                
            case 2:
                return this.price = 18;
                
            case 5:
                return this.price = 40;
                
            case 21:
                return this.price = 65;
                
            default:
                return this.price = 0;
        }

    }

    private int generateStartedTime() {
        int timeNow = 0;
        return timeNow;
    }
    
    public String getNameGame() {
        return nameGame;
    }
    
    public void setNameGame(String nameGame) {
        this.nameGame = nameGame;
    }
    
    public int getIdGame() {
        return idGame;
    }
    
    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }
    
    public int getStartHour() {
        return startHour;
    }
    
    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }
    
    public int getEndHour() {
        return endHour;
    }
    
    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }
    
    public int getTimePeriod() {
        return timePeriod;
    }
    
    public void setTimePeriod(int timePeriod) {
        this.timePeriod = timePeriod;
    }
    
    public P getPlayer() {
        return player;
    }
    
    public void setPlayer(P player) {
        this.player = player;
    }
    
    public void printGame() {
        System.out.println("Game name: " + nameGame);
        System.out.println("Game id: " + idGame);
        System.out.println("Game start hour: " + startHour);
        System.out.println("Game end hour: " + endHour);
        System.out.println("Game time period: " + timePeriod);
        System.out.println("Player name: " + player.getNamePlayer());
    }

    
    
    public  void storeGame(String console, int place, String screen, int startHour, int endHour, int price) {
        listGame.add(console);
        listGame.add(place);
        listGame.add(startHour);
        listGame.add(endHour);
        listGame.add(price);
        listGame.add(screen);
        System.out.println("hhhhhhhhhhhhhhhhhhhhhh" );
    }

    public void getAllGame() {
        System.out.println("********************************");
        for (Object game : listGame) {
            System.out.println(game);
        }

    }
}
