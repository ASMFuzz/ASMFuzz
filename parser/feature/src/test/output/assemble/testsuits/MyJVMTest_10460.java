import javax.management.*;

public class MyJVMTest_10460 {

    static String nParam1 = "2vD+0tet.M";

    static Object nParam2 = 0;

    static long nParam3 = 6813073167674056424L;

    static long nParam4 = 0;

    static String nParam5 = "@qZiYeS9&L";

    static Notification n = new Notification(nParam1, nParam2, nParam3, nParam4, nParam5);

    static Object h = 0;

    static int count = 5;

    Notification handleNotification(Notification n, Object h) {
        if (!n.getType().equals("x")) {
            System.out.println("TEST FAILED: received bogus notif: " + n + " (type=" + n.getType() + ")");
            System.exit(1);
        }
        count++;
        return n;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10460().handleNotification(n, h);
    }
}
