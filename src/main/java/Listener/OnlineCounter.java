package Listener;

/**
 * Created by 123 on 2017/06/22.
 */
public class OnlineCounter {
    private static long online = 0;

    public static void raise() {
        online++;
        System.out.println(online);
    }

    public static void reduce() {
        online--;
        System.out.println(online);
    }

    public static long getOnline() {
        return online;

    }
}
