import javax.management.*;
import javax.management.monitor.*;

public class MyJVMTest_1211 {

    static String notificationParam1 = "sR) Ej6~\"B";

    static Object notificationParam2 = 1750104136;

    static long notificationParam3 = 334950901662819621L;

    static long notificationParam4 = 9223372036854775807L;

    static String notificationParam5 = "0jaE.dGK0J";

    static Notification notification = new Notification(notificationParam1, notificationParam2, notificationParam3, notificationParam4, notificationParam5);

    static Object handback = 199177855;

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
        new MyJVMTest_1211().handleNotification(notification, handback);
    }
}
