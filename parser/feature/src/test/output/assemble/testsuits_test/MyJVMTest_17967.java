import java.util.concurrent.*;
import javax.management.*;
import javax.management.remote.*;

public class MyJVMTest_17967 {

    static String notifParam1 = "ZsGY59KtR@";

    static Object notifParam2 = 8;

    static long notifParam3 = 9223372036854775807L;

    static long notifParam4 = -9223372036854775808L;

    static Notification notif = new Notification(notifParam1, notifParam2, notifParam3, notifParam4);

    static Object handback = 0;

    static int nb = 10;

    static int receivedNotifs = 0;

    static int[] lock = new int[0];

    Object handleNotification(Notification notif, Object handback) {
        synchronized (lock) {
            if (++receivedNotifs >= nb) {
                lock.notifyAll();
            }
        }
        return handback;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17967().handleNotification(notif, handback);
    }
}
