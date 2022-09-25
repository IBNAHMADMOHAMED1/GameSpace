
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Player {

    private String name;
    private int post;
    private LocalTime start;
    private LocalTime end;
    private int duration;
    private Games gameName;
    private int amount;
    private String console;
    private String screen;

    private static final String FILE_NAME = "C:\\Users\\youcode\\Desktop\\simpl_java\\scaner\\GameSpace\\src\\profit.txt";

    List<HashMap> users = new ArrayList();
    List<HashMap> lobby = new LinkedList<>(); // linked list because it is faster than array list

    int number = 1;
    boolean pushToLobby = false;
    LocalTime time = LocalTime.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd ");
    LocalDateTime now = LocalDateTime.now();

    public void createClient() {
        if (users.size() < 10) {
            newClient(screen);
        } else if (users.size() < 17) {
            System.out.print("No more post available new client will wait in the lobby \n");
            newClient(screen);
            System.out.print("You are number " + number + " in the queue \n");
            number++;
        } else {
            System.out.print("No more post available\n");
        }
    }

    public void newClient(String string) {
        HashMap client = new HashMap();
        Post spot = new Post();

        int ref = generateRandomInt(10000); // generate random number

        Scanner scanner = new Scanner(System.in); // Scanner declaration

        System.out.print("Enter the Name : \n");
        name = scanner.nextLine();

        printGames();

        int game = scanner.nextInt();
        switch (game) {

            case 1:
                gameName = Games.PES;
                break;
            case 2:
                gameName = Games.FIFA;
                break;
            case 3:
                gameName = Games.COD;
                break;
            case 4:
                gameName = Games.GOW;
                break;
            case 5:
                gameName = Games.FORZA;
                break;
            case 6:
                gameName = Games.RDR;
                break;
            case 7:
                gameName = Games.MARIO;
                break;
            case 8:
                gameName = Games.MINECRAFT;
                break;
            case 9:
                gameName = Games.FORTNITE;
                break;
        }
        ;
        int isalreadytaken1 = 0;
        int isalreadytaken2 = 0;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).get("post").equals(gameName.postN1))
                isalreadytaken1 = 1;
            else
                isalreadytaken1 = 0;
            if (users.get(i).get("post").equals(gameName.postN2))
                isalreadytaken2 = 1;
            else
                isalreadytaken2 = 0;
        }
        if (isalreadytaken1 == 0 && isalreadytaken2 == 0) {
            post = gameName.postN1;
            console = gameName.console;
            screen = gameName.screen;
            System.out.println("You have chosen the screen " + gameName.screen);

        } else if (isalreadytaken1 != 0 && isalreadytaken2 == 0) {
            post = gameName.postN2;
            console = gameName.console;
            screen = gameName.screen;
        } else
            pushToLobby = true;

        scanner.nextLine();
        start = time;
        if (pushToLobby)
            start = spot.isAvailable(start, users, gameName);
           duration = printDuration();
           checkDuration(duration, start);

        end = start.plusMinutes(duration);

        switch (duration) {
            case 30:
                amount = 5;
                end = start.plusMinutes(30);
                break;
            case 1:
                amount = 10;
                end = start.plusMinutes(60);
                break;
            case 2:
                amount = 18;
                end = start.plusMinutes(120);
                break;
            case 5:
                amount = 40;
                end = start.plusMinutes(300);
                break;
            case 9:
                amount = 65;
                end = start.plusMinutes(540);
                break;
        }
        spot.getMaxEndTime(users);
        if (end.isAfter(LocalTime.parse("14:00:00")) && end.isBefore(LocalTime.parse("15:00:00"))) {
            System.out.println("You can't play between 12:00 and 14:00 you can come back 12:00 or after 14:00");
            end = LocalTime.parse("12:00:00");
            return;
        }
        if (end.isAfter(LocalTime.parse("20:00:00")) || end.isBefore(LocalTime.parse("09:00:00"))) {
            System.out.println("You can't Play come back tomorrow or play till 20:00");
            // end = LocalTime.parse("20:00:00");
            return;
        }
        // if choice is 9 and afetr 11:00 then impossible
        if (end.isBefore(LocalTime.parse("12:00:00"))) {
            // if choice + start is after 12:00 then impossible
            if (start.plusMinutes(duration).isAfter(LocalTime.parse("12:00:00"))) {
                System.out.println("You can't play between 12:00 and 14:00µ you can come back  after 14:00");
                end = LocalTime.parse("12:00:00");
                return;
            }
            if (end.isBefore(LocalTime.parse("20:00:00")) || end.isAfter(LocalTime.parse("14:00:00"))) {
                // if choice + start is after 20:00 then impossible
                if (start.plusMinutes(duration).isAfter(LocalTime.parse("20:00:00"))) {
                    System.out.println("You can't Play come back tomorrow or play till 20:00");
                    // end = LocalTime.parse("20:00:00");
                    return;
                }
            }

        }

        client.put("name", name);
        client.put("post", post);
        client.put("start", start);
        client.put("end", end);
        client.put("duration", duration);
        client.put("gameName", gameName);
        client.put("ref", ref);
        client.put("amount", amount);
        client.put("console", console);
        client.put("Screen", screen);
        client.put("date", dtf.format(now));

        pushToTextFile((int) client.get("amount"),client.get("name").toString(),client.get("date").toString());


        System.out.println("post : " + post);
        System.out.println("start : " + start);
        System.out.println("end : " + end);

        users.add(client);

        if (pushToLobby) {
            System.out.println("You are in the lobby you will be notified when a spot is available");
            lobby.add(client);
        }

    }

    public void showClients() {
        System.out.println("List of clients : ");
        System.out.println(users);
        String[] details = new String[users.size()];
        for (int i = 0; i < users.size(); i++) {
            int dur = (int) users.get(i).get("duration");
            details[i] = "Name : " + users.get(i).get("name") + " Post : " + users.get(i).get("post") + " Start : "
                    + users.get(i).get("start") + " End : " + users.get(i).get("end") + " Duration : "
                    + users.get(i).get("duration")
                    + (dur == 30 ? " Minutes Game" : (dur == 1 ? " hour" : "hours") + " Game : ")
                    + users.get(i).get("gameName") + " Ref : " + users.get(i).get("ref") + " Amount : "
                    + users.get(i).get("amount") + " Console : " + users.get(i).get("console") + " Screen : "
                    + users.get(i).get("screen");
        }

        if (users.size() == 0) {
            System.out.println("No clients");
            return;
        }
        for (int i = 0; i < details.length; i++) {
            System.out.println("**************************************");
            System.out.println("Client " + (i + 1) + " : " + details[i]);
            System.out.println("**************************************\n");
        }

    }

    public void showLobby() {
        if (lobby.size() <= 0) {
            System.out.print("lobby is empty \n");
            return;
        }
        System.out.print("lobby : \n" + lobby + "\n");
    }

    /**
     * @return
     */
    public int getProfit() {
        int totalProfit = 0;
        for (int i = 0; i < users.size(); i++) {
            totalProfit += (int) users.get(i).get("amount");
        }
        return totalProfit;
    }

    /**
     * @param upperbound
     * @return
     */
    public int generateRandomInt(int upperbound) {
        Random rand = new Random(); // instance of random class to generate random number
        int int_random = rand.nextInt(upperbound); // generate random number
        return int_random;
    }

    /**
     * 
     */
    public void printGames() {
        Games[] games = Games.values();
        for (int i = 0; i < games.length; i++) {
            System.out.println((i + 1) + ". " + games[i]);
        }
    }

    public void checkDuration(int duration, LocalTime start) {

    }

    public String choiceScreen(String availableScreen) {
        System.out.println("Available Screens : " + availableScreen);
        System.out.println("Choose a Screen : ");
        Scanner sc = new Scanner(System.in);
        String screen = sc.nextLine();
        return screen;
    }

    public void notifyLobby() {
        if (lobby.size() > 0) {
            System.out.println("A spot is available");
            System.out.println("lobby : " + lobby);
        }
    }

    public int printDuration() {
        System.out.println("Select a duration : ");
        System.out.println("30. 30 minutes : 5 DH");
        System.out.println("1. 1 hour : 10 DH");
        System.out.println("2. 2 hours : 18 DH");
        System.out.println("5. 5 hours : 40 DH");
        System.out.println("9. All day : 65 DH");
        Scanner sc = new Scanner(System.in);
        int duration = sc.nextInt();
        return duration;
    }

    public void WriteObjectToJSONFile() {
        // json i want to write to json file without gson
        for (int i = 0; i < users.size(); i++) {
            String json = "{";
            // ADD DATE
            json += "\"date\" : \"" + users.get(i).get("date") + "\",";
            json += "\"name\" : \"" + users.get(i).get("name") + "\",";
            json += "\"post\" : \"" + users.get(i).get("post") + "\",";
            json += "\"start\" : \"" + users.get(i).get("start") + "\",";
            json += "\"end\" : \"" + users.get(i).get("end") + "\",";
            json += "\"duration\" : \"" + users.get(i).get("duration") + "\",";
            json += "\"gameName\" : \"" + users.get(i).get("gameName") + "\",";
            json += "\"ref\" : \"" + users.get(i).get("ref") + "\",";
            json += "\"amount\" : \"" + users.get(i).get("amount") + "\",";
            json += "\"console\" : \"" + users.get(i).get("console") + "\",";
            json += "\"screen\" : \"" + users.get(i).get("screen") + "\"";
            json += "}";

            pushToJSONFile(json);
        }
    }

    public void pushToJSONFile(String json) {
        try {
            FileWriter file = new FileWriter(FILE_NAME, true);
            // we have array of objects in the file we need new line to separate them
            file.write(json + ",\n");
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    
    public void pushToTextFile(int totalProfit, String name, String date) {
        try {
            FileWriter file = new FileWriter(FILE_NAME, true);
            File file2 = new File(FILE_NAME);
            Scanner sc = new Scanner(file2);
            String line = "name : " + name + " | date : " + date + " | profit : " + totalProfit + " DH";
            file.write(line + ".\n");
            file.flush();
            file.close();
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMonthlyProfit() {
        int[] profits = getProfits();
       
        System.out.println("Total profit of the day : " + profits[0] + " DH");
        System.out.println("Total profit of the week : " + profits[1] + " DH");
        System.out.println("Total profit of the month : " + profits[2] + " DH");
        System.out.println("GOOD BYE");

    }
    public int[] getProfits() {
        int profitMonth = 0;
        int profitDay = 0;
        int profit = 0;
        String currentMonth = LocalDate.now().toString().substring(5, 7);
        // get the current day
        String currentDay = LocalDate.now().toString().substring(8, 10);
        // get the current year
        String currentYear = LocalDate.now().toString().substring(0, 4);

        try {
            File file = new File(FILE_NAME);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] words = line.split(" ");
                //  name : name | date : date | profit : profit DH . => We have 13 words
                String date = words[6];
                String month = date.substring(5, 7);
                String day = date.substring(8, 10);
                String year = date.substring(0, 4);
                int profitString = (int) Double.parseDouble(words[11]);
                if (month.equals(currentMonth) && year.equals(currentYear)) {
                    profitMonth += profitString;
                }
                if (day.equals(currentDay) && year.equals(currentYear)) {
                    profitDay += profitString;
                }
                profit += profitString;
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int[] profits = {profitDay, profitMonth, profit};
        return profits;
    }
    
    public void removeLine(String lineContent) {
        System.out.println("lineContent : " + lineContent);
        // remove the line from the file
        try {
            File file = new File(FILE_NAME);
            Scanner sc = new Scanner(file);
            // read the file content
            String content = "";
            while (sc.hasNextLine()) {
                content += sc.nextLine() + System.lineSeparator();
            }
            content = content.replace(lineContent, "");
       
            FileWriter writer = new FileWriter(FILE_NAME);
            writer.write(content);
            sc.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            
        }
       
        
    }
    
        public List<HashMap> ReadObjectFromJSONFile() {
            List<HashMap> usersJson = new ArrayList<HashMap>();
            JSONParser parser = new JSONParser();
            // try {
            // Object obj = parser.parse(new FileReader(
            // "C:\\Users\\youcode\\Desktop\\simpl_java\\scaner\\GameSpace\\src\\test.json"));
            // JSONArray jsonArray = new JSONArray();
            // for (int i = 0; i < jsonArray.size(); i++) {
            // JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            // HashMap<String, Object> user = new HashMap<String, Object>();
            // user.put("date", jsonObject.get("date"));
            // user.put("name", jsonObject.get("name"));
            // user.put("post", jsonObject.get("post"));
            // user.put("start", jsonObject.get("start"));
            // user.put("end", jsonObject.get("end"));
            // user.put("duration", jsonObject.get("duration"));
            // user.put("gameName", jsonObject.get("gameName"));
            // user.put("ref", jsonObject.get("ref"));
            // user.put("amount", jsonObject.get("amount"));
            // user.put("console", jsonObject.get("console"));
            // user.put("screen", jsonObject.get("screen"));
            // usersJson.add(user);
            // }
            // } catch (Exception e) {
            // e.printStackTrace();
            // }
    
            return usersJson;
    
        }

}