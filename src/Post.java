
import java.time.LocalTime;
import java.util.*;

public class Post {


    /**
     * isAvailable method checks if the time is available or not
     *  
     *  @param users
     *  @param users
     * @param startTime
     * @param users
     * @param game
     * @return
     */
    public LocalTime isAvailable(Object startTime, List users, Games game) {

        LocalTime start = LocalTime.parse(startTime.toString());

        for (Object user : users) {
            HashMap us = (HashMap) user;
            if (us.get("gameName").equals(game)) {
                LocalTime end = LocalTime.parse(us.get("end").toString());

                if (start.isAfter(end)) {
                    return start;
                } else {
                    start = end;
                    if (start.equals(LocalTime.parse("20:00"))) {
                        System.out.println("No more games today");
                        System.exit(0);
                    }
                }
            }
        }
        return start;
    }
    public LocalTime getMaxEndTime(List users) {
        LocalTime minEndTime = LocalTime.of(0, 0);
        for (Object user : users) {
            HashMap us = (HashMap) user; // hashmap is a map of key value
            if (LocalTime.parse(us.get("end").toString()).isAfter(minEndTime)) {
                minEndTime = LocalTime.parse(us.get("end").toString());
                System.out.println("In Time is " + minEndTime);
            }
        }
        return minEndTime;
    }

}