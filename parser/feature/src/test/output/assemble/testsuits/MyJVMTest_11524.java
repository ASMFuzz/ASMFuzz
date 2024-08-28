import javax.management.*;

public class MyJVMTest_11524 {

    static String notificationParam1 = "?<n0}l|$t'";

    static Object notificationParam2 = 5;

    static long notificationParam3 = 0;

    static Notification notification = new Notification(notificationParam1, notificationParam2, notificationParam3);

    boolean isNotificationEnabled(Notification notification) {
        System.out.println(">>> FilterExceptionTest-filter: throws exception.");
        throw new RuntimeException("For test");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11524().isNotificationEnabled(notification));
    }
}
