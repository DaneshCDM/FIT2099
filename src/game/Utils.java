package game;

import java.util.Random;

public class Utils {

    public static int randomVal() {
        Random r = new Random();
        int low = 10000;
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }

    public static int randomIndex() {
        Random r = new Random();
        int low = 0;
        int high = 3;
        return (r.nextInt(high - low + 1) + low);
    }

}