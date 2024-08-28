import java.util.*;
import javax.management.*;
import javax.management.monitor.*;

public class MyJVMTest_2622 {

    static String nParam1 = "2y EH-<'Sa";

    static Object nParam2 = 8;

    static long nParam3 = -9223372036854775808L;

    static long nParam4 = -9223372036854775808L;

    static String nParam5 = "uBKL5K'NU[";

    static Notification n = new Notification(nParam1, nParam2, nParam3, nParam4, nParam5);

    static Object h = 1;

    static int N = 100;

    static int count = 1;

    Notification handleNotification(Notification n, Object h) {
        if (!(n instanceof MonitorNotification)) {
            System.out.println("TEST FAILED: bad notif: " + n.getClass().getName());
            System.exit(1);
        }
        if (n.getType().indexOf("error") >= 0) {
            System.out.println("TEST FAILED: error notif: " + n.getType());
            System.exit(1);
        }
        count++;
        return n;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2622().handleNotification(n, h);
    }
}
