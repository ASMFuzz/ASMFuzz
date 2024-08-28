import javax.management.*;

public class MyJVMTest_1259 {

    static String nParam1 = "ND&GMYw:45";

    static Object nParam2 = 1;

    static long nParam3 = -9223372036854775808L;

    static long nParam4 = -6375103458473058312L;

    static Notification n = new Notification(nParam1, nParam2, nParam3, nParam4);

    static Object h = 2;

    static int count = 6;

    Notification handleNotification(Notification n, Object h) {
        if (!n.getType().equals("x")) {
            System.out.println("TEST FAILED: received bogus notif: " + n + " (type=" + n.getType() + ")");
            System.exit(1);
        }
        count++;
        return n;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1259().handleNotification(n, h);
    }
}
