import java.lang.management.*;
import javax.management.*;
import static java.lang.management.ManagementFactory.*;

public class MyJVMTest_3171 {

    static String notifParam1 = "kAC/I]g/m^";

    static Object notifParam2 = 0;

    static long notifParam3 = 0;

    static String notifParam4 = "Ql/lQ:7.M=";

    static Notification notif = new Notification(notifParam1, notifParam2, notifParam3, notifParam4);

    static Object handback = 4;

    Object handleNotification(Notification notif, Object handback) {
        return;
        return handback;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3171().handleNotification(notif, handback);
    }
}
