import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.rmi.server.*;
import java.util.*;
import javax.management.*;
import javax.management.remote.*;
import javax.management.remote.rmi.*;

public class MyJVMTest_6459 {

    static String nParam1 = "^UxAruZ89I";

    static Object nParam2 = -2021498726;

    static long nParam3 = -9223372036854775808L;

    static Notification n = new Notification(nParam1, nParam2, nParam3);

    boolean isNotificationEnabled(Notification n) {
        System.out.println("Filter: " + n + " (" + n.getType() + ")");
        final String failed = JMXConnectionNotification.FAILED;
        return (n instanceof JMXConnectionNotification && n.getType().equals(JMXConnectionNotification.FAILED));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6459().isNotificationEnabled(n));
    }
}
