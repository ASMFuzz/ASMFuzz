import java.util.*;
import java.net.*;
import javax.management.*;
import javax.management.remote.*;

public class MyJVMTest_10319 {

    static String proto = "eTIO\\Xp\"k'";

    static MBeanServer mbs = MBeanServerFactory.createMBeanServer();

    static ObjectName timer = null;

    static NotificationListener listener = new NotificationListener() {

        public void handleNotification(Notification notification, Object handback) {
        }
    };

    boolean test(String proto) throws Exception {
        System.out.println("\ntest: Test for protocol " + proto);
        JMXServiceURL u = null;
        JMXConnectorServer server = null;
        try {
            u = new JMXServiceURL(proto, null, 0);
            server = JMXConnectorServerFactory.newJMXConnectorServer(u, null, mbs);
        } catch (MalformedURLException e) {
            System.out.println("Skipping unsupported URL " + proto);
            return true;
        }
        server.start();
        u = server.getAddress();
        System.out.println("test: create a server on: " + u);
        JMXConnector client = JMXConnectorFactory.connect(u, null);
        MBeanServerConnection conn = client.getMBeanServerConnection();
        final ClassLoader orgCL = Thread.currentThread().getContextClassLoader();
        System.out.println("test: the orginal classloader is " + orgCL);
        final URL url = new URL("file:/xxx");
        final ClassLoader newCL = new URLClassLoader(new URL[] { url }, orgCL);
        try {
            System.out.println("test: set classloader to " + newCL);
            Thread.currentThread().setContextClassLoader(newCL);
            conn.addNotificationListener(timer, listener, null, null);
            client.close();
            server.stop();
            if (Thread.currentThread().getContextClassLoader() != newCL) {
                System.out.println("ERROR: The client class loader is lost.");
                return false;
            } else {
                System.out.println("test: Bye bye.");
                return true;
            }
        } finally {
            Thread.currentThread().setContextClassLoader(orgCL);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10319().test(proto));
    }
}
