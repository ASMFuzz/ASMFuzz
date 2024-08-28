import javax.management.*;
import javax.management.monitor.*;

public class MyJVMTest_11424 {

    static String notificationParam1 = "kj4(TO}q7o";

    static Object notificationParam2 = -294384657;

    static long notificationParam3 = -9223372036854775808L;

    static Notification notification = new Notification(notificationParam1, notificationParam2, notificationParam3);

    static Object handback = -1338305764;

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
                synchronized (this) {
                    messageReceived = true;
                    notifyAll();
                }
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
        new MyJVMTest_11424().handleNotification(notification, handback);
    }
}
