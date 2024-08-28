import javax.management.*;

public class MyJVMTest_15826 {

    static String nParam1 = "r/8R9.gfN_";

    static Object nParam2 = 0;

    static long nParam3 = -9223372036854775808L;

    static long nParam4 = 9223372036854775807L;

    static Notification n = new Notification(nParam1, nParam2, nParam3, nParam4);

    static Object hb = 4;

    static Exception listenerException = null;

    Notification handleNotification(Notification n, Object hb) {
        FilterExceptionTest.listenerException = new Exception("The listener received unexpected notif.");
        return n;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15826().handleNotification(n, hb);
    }
}
