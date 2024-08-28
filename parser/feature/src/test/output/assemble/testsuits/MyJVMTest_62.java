import javax.management.*;
import javax.management.monitor.*;

public class MyJVMTest_62 {

    static String notificationParam1 = "[t58<m$rj~";

    static Object notificationParam2 = 3;

    static long notificationParam3 = 9223372036854775807L;

    static long notificationParam4 = -9223372036854775808L;

    static String notificationParam5 = "3|2|-*I)Au";

    static Notification notification = new Notification(notificationParam1, notificationParam2, notificationParam3, notificationParam4, notificationParam5);

    static Object handback = 1648519129;

    void echo(String message) {
        System.out.println(message);
    }

    static boolean messageReceived = false;

    MonitorNotification handleNotification(Notification notification, Object handback) {
        MonitorNotification n = (MonitorNotification) notification;
        echo("\tInside handleNotification...");
        String type = n.getType();
        try {
            if (type.equals(MonitorNotification.OBSERVED_ATTRIBUTE_TYPE_ERROR)) {
                echo("\t\t" + n.getObservedAttribute() + " is null");
                echo("\t\tDerived Gauge = " + n.getDerivedGauge());
                echo("\t\tTrigger = " + n.getTrigger());
                messageReceived = true;
            } else {
                echo("\t\tSkipping notification of type: " + type);
            }
        } catch (Exception e) {
            echo("\tError in handleNotification!");
            e.printStackTrace(System.out);
        }
        return n;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_62().handleNotification(notification, handback);
    }
}
