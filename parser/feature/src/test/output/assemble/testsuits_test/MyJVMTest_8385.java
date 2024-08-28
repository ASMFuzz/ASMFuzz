import java.util.concurrent.*;
import javax.management.*;
import javax.management.remote.*;

public class MyJVMTest_8385 {

    static String notifParam1 = "K}*s0Pb$7>";

    static Object notifParam2 = -1714293709;

    static long notifParam3 = 0;

    static Notification notif = new Notification(notifParam1, notifParam2, notifParam3);

    static Object handback = 5;

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
        new MyJVMTest_8385().handleNotification(notif, handback);
    }
}
