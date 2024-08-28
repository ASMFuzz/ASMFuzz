import javax.management.*;
import javax.management.monitor.*;

public class MyJVMTest_10411 {

    static String notificationParam1 = "9%xfITwu>;";

    static Object notificationParam2 = 3;

    static long notificationParam3 = 7224999680719252898L;

    static long notificationParam4 = 0;

    static String notificationParam5 = "I?j(Z?{v`S";

    static Notification notification = new Notification(notificationParam1, notificationParam2, notificationParam3, notificationParam4, notificationParam5);

    static Object handback = 175540562;

    void echo(String message) {
        System.out.println(message);
    }

    static Number threshold = new Integer(2);

    static boolean messageReceived = false;

    MonitorNotification handleNotification(Notification notification, Object handback) {
        MonitorNotification n = (MonitorNotification) notification;
        echo("\tInside handleNotification...");
        String type = n.getType();
        try {
            if (type.equals(MonitorNotification.THRESHOLD_VALUE_EXCEEDED)) {
                echo("\t\t" + n.getObservedAttribute() + " has reached or exceeded the threshold");
                echo("\t\tDerived Gauge = " + n.getDerivedGauge());
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
        new MyJVMTest_10411().handleNotification(notification, handback);
    }
}
