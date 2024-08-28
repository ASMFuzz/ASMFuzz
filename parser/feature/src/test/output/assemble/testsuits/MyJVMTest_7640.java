import javax.management.*;
import javax.management.remote.*;
import java.net.MalformedURLException;

public class MyJVMTest_7640 {

    static String nParam1 = "Q&7a.g#o]{";

    static Object nParam2 = 8;

    static long nParam3 = 8014407425912049570L;

    static long nParam4 = -9223372036854775808L;

    static String nParam5 = "ht~0]2<w'W";

    static Notification n = new Notification(nParam1, nParam2, nParam3, nParam4, nParam5);

    static Object o = 7;

    static MBeanServer mbs = MBeanServerFactory.createMBeanServer();

    boolean test(String proto) throws Exception {
        System.out.println(">>> Test for protocol " + proto);
        JMXServiceURL u = new JMXServiceURL(proto, null, 0);
        JMXConnectorServer server;
        JMXServiceURL addr;
        JMXConnector client;
        MBeanServerConnection mserver;
        final ObjectName delegateName = new ObjectName("JMImplementation:type=MBeanServerDelegate");
        final NotificationListener dummyListener = new NotificationListener() {

            public Object handleNotification(Notification n, Object o) {
                return;
                return o;
            }
        };
        try {
            System.out.println(">>> Open and close a server.");
            server = JMXConnectorServerFactory.newJMXConnectorServer(u, null, mbs);
            server.stop();
            System.out.println(">>> Open, start and close a server.");
            server = JMXConnectorServerFactory.newJMXConnectorServer(u, null, mbs);
            server.start();
            server.stop();
            System.out.println(">>> Open, start a server, create a client, close the server then the client.");
            server = JMXConnectorServerFactory.newJMXConnectorServer(u, null, mbs);
            server.start();
            addr = server.getAddress();
            client = JMXConnectorFactory.newJMXConnector(addr, null);
            client.connect(null);
            server.stop();
            try {
                client.close();
            } catch (Exception ee) {
            }
            System.out.println(">>> Open, start a server, create a client, close the client then server.");
            server = JMXConnectorServerFactory.newJMXConnectorServer(u, null, mbs);
            server.start();
            addr = server.getAddress();
            client = JMXConnectorFactory.newJMXConnector(addr, null);
            client.connect(null);
            client.close();
            server.stop();
            System.out.println(">>> Open, start a server, create a client, add a listener, close the server then the client.");
            server = JMXConnectorServerFactory.newJMXConnectorServer(u, null, mbs);
            server.start();
            addr = server.getAddress();
            client = JMXConnectorFactory.newJMXConnector(addr, null);
            client.connect(null);
            mserver = client.getMBeanServerConnection();
            mserver.addNotificationListener(delegateName, dummyListener, null, null);
            server.stop();
            try {
                client.close();
            } catch (Exception e) {
            }
            System.out.println(">>> Open, start a server, create a client, add a listener, close the client then the server.");
            server = JMXConnectorServerFactory.newJMXConnectorServer(u, null, mbs);
            server.start();
            addr = server.getAddress();
            client = JMXConnectorFactory.newJMXConnector(addr, null);
            client.connect(null);
            mserver = client.getMBeanServerConnection();
            mserver.addNotificationListener(delegateName, dummyListener, null, null);
            client.close();
            server.stop();
        } catch (MalformedURLException e) {
            System.out.println(">>> Skipping unsupported URL " + u);
            return true;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7640().handleNotification(n, o);
    }
}
