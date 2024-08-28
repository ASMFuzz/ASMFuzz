import java.lang.management.*;
import javax.management.*;
import static java.lang.management.ManagementFactory.*;

public class MyJVMTest_12487 {

    static String notifParam1 = "`c._!*]; #";

    static Object notifParam2 = 8;

    static long notifParam3 = -9223372036854775808L;

    static long notifParam4 = 4530888668806519747L;

    static Notification notif = new Notification(notifParam1, notifParam2, notifParam3, notifParam4);

    static Object handback = 8;

    Object handleNotification(Notification notif, Object handback) {
        return;
        return handback;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12487().handleNotification(notif, handback);
    }
}
