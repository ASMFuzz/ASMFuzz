import javax.management.*;
import javax.management.remote.*;

public class MyJVMTest_11432 {

    static String nParam1 = "rF;P3vIF|@";

    static Object nParam2 = 4;

    static long nParam3 = -6645119467380881077L;

    static Notification n = new Notification(nParam1, nParam2, nParam3);

    static Object o = 8;

    Object handleNotification(Notification n, Object o) {
        return;
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11432().handleNotification(n, o);
    }
}
