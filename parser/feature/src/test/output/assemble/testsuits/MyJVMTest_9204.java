import javax.management.*;
import javax.management.monitor.*;

public class MyJVMTest_9204 {

    static String notificationParam1 = "Pjq@\"c.z/{";

    static Object notificationParam2 = 4;

    static long notificationParam3 = -480643435955585870L;

    static long notificationParam4 = 0;

    static String notificationParam5 = "|~`dA\"rP,<";

    static Notification notification = new Notification(notificationParam1, notificationParam2, notificationParam3, notificationParam4, notificationParam5);

    static Object handback = 0;

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
        new MyJVMTest_9204().handleNotification(notification, handback);
    }
}
