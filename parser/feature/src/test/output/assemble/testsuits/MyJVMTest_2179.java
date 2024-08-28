import javax.management.*;
import javax.management.remote.*;

public class MyJVMTest_2179 {

    static String nParam1 = "R/eoI=rk>Z";

    static Object nParam2 = 5;

    static long nParam3 = 9223372036854775807L;

    static String nParam4 = "bnlY(36*!t";

    static Notification n = new Notification(nParam1, nParam2, nParam3, nParam4);

    static Object o = 547817528;

    Object handleNotification(Notification n, Object o) {
        return;
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2179().handleNotification(n, o);
    }
}
