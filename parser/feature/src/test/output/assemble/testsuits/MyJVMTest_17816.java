import java.util.*;
import java.util.concurrent.*;
import javax.management.*;
import javax.management.remote.*;

public class MyJVMTest_17816 {

    static String nParam1 = "q<R}'^GjDC";

    static Object nParam2 = 0;

    static long nParam3 = 0;

    static long nParam4 = 0;

    static Notification n = new Notification(nParam1, nParam2, nParam3, nParam4);

    static Object h = 1924761627;

    static Semaphore semaphore = new Semaphore(0);

    Notification handleNotification(Notification n, Object h) {
        semaphore.release();
        return n;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17816().handleNotification(n, h);
    }
}
