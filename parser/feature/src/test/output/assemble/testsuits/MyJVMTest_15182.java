import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.*;
import javax.management.*;
import javax.management.remote.*;

public class MyJVMTest_15182 {

    static String nParam1 = "mHO{jBi#eg";

    static Object nParam2 = -2081114415;

    static long nParam3 = 0;

    static Notification n = new Notification(nParam1, nParam2, nParam3);

    static Object h = 0;

    static Semaphore semaphore = new Semaphore(0);

    static Object wrapped = 0;

    Notification handleNotification(Notification n, Object h) {
        semaphore.release();
        return n;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15182().handleNotification(n, h);
    }
}
