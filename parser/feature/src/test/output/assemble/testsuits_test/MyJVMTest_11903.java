import java.util.*;
import javax.management.*;
import javax.management.monitor.*;

public class MyJVMTest_11903 {

    static String nParam1 = "E7_&l\"yp/N";

    static Object nParam2 = 784184107;

    static long nParam3 = -9223372036854775808L;

    static Notification n = new Notification(nParam1, nParam2, nParam3);

    static Object h = 0;

    static int N = 100;

    static int count = 356131747;

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
        new MyJVMTest_11903().handleNotification(n, h);
    }
}
