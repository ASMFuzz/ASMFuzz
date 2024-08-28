import java.util.*;
import javax.management.*;
import javax.management.monitor.*;

public class MyJVMTest_1490 {

    static String nParam1 = "hqEaPbk.7H";

    static Object nParam2 = 0;

    static long nParam3 = -9223372036854775808L;

    static String nParam4 = "-;lpHl|JzV";

    static Notification n = new Notification(nParam1, nParam2, nParam3, nParam4);

    static Object h = 597125797;

    static int count = -1816596387;

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
        new MyJVMTest_1490().handleNotification(n, h);
    }
}
