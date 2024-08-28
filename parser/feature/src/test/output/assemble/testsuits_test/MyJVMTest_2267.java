import javax.management.*;

public class MyJVMTest_2267 {

    static String notificationParam1 = "e,-bKc{wda";

    static Object notificationParam2 = 0;

    static long notificationParam3 = 9223372036854775807L;

    static String notificationParam4 = "^c3\\B]%v@(";

    static Notification notification = new Notification(notificationParam1, notificationParam2, notificationParam3, notificationParam4);

    boolean isNotificationEnabled(Notification notification) {
        System.out.println(">>> FilterExceptionTest-filter: throws exception.");
        throw new RuntimeException("For test");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2267().isNotificationEnabled(notification));
    }
}
