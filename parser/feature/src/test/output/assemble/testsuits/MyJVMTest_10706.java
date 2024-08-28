import java.util.*;
import javax.management.*;
import javax.management.monitor.*;

public class MyJVMTest_10706 {

    static String nParam1 = "R`,x`T0F8q";

    static Object nParam2 = 1161214958;

    static long nParam3 = -9223372036854775808L;

    static Notification n = new Notification(nParam1, nParam2, nParam3);

    static Object h = 7;

    static int count = 2;

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
        new MyJVMTest_10706().handleNotification(n, h);
    }
}
