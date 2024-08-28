import javax.management.*;

public class MyJVMTest_6346 {

    static String nParam1 = "_egwk?W`25";

    static Object nParam2 = 0;

    static long nParam3 = -9223372036854775808L;

    static long nParam4 = 9223372036854775807L;

    static String nParam5 = ".=$p-RO#F+";

    static Notification n = new Notification(nParam1, nParam2, nParam3, nParam4, nParam5);

    static Object hb = 7;

    static Exception listenerException = null;

    Notification handleNotification(Notification n, Object hb) {
        FilterExceptionTest.listenerException = new Exception("The listener received unexpected notif.");
        return n;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6346().handleNotification(n, hb);
    }
}
