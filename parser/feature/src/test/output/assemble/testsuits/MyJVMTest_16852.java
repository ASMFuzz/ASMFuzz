import javax.management.*;
import javax.management.remote.*;
import java.net.MalformedURLException;

public class MyJVMTest_16852 {

    static String nParam1 = "7sa\"w\\<`OE";

    static Object nParam2 = 3;

    static long nParam3 = -188687188767390578L;

    static long nParam4 = 2213636444878583717L;

    static Notification n = new Notification(nParam1, nParam2, nParam3, nParam4);

    static Object o = 0;

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
            server = JMXConnectorServerFactory.newJMXConnectorServer(u, null, mbs);
            server.start();
            addr = server.getAddress();
            client = JMXConnectorFactory.newJMXConnector(addr, null);
            client.connect(null);
            mserver = client.getMBeanServerConnection();
            String s1 = "1";
            String s2 = "2";
            String s3 = "3";
            for (int i = 0; i < 3; i++) {
                mserver.addNotificationListener(delegateName, dummyListener, null, s1);
                mserver.addNotificationListener(delegateName, dummyListener, null, s2);
                mserver.addNotificationListener(delegateName, dummyListener, null, s3);
                mserver.removeNotificationListener(delegateName, dummyListener, null, s3);
                mserver.removeNotificationListener(delegateName, dummyListener, null, s2);
                mserver.removeNotificationListener(delegateName, dummyListener, null, s1);
            }
            for (int i = 0; i < 3; i++) {
                mserver.addNotificationListener(delegateName, dummyListener, null, s1);
                mserver.addNotificationListener(delegateName, dummyListener, null, s2);
                mserver.addNotificationListener(delegateName, dummyListener, null, s3);
                mserver.removeNotificationListener(delegateName, dummyListener);
                try {
                    mserver.removeNotificationListener(delegateName, dummyListener, null, s1);
                    System.out.println("Failed to remove a listener.");
                    return false;
                } catch (ListenerNotFoundException lne) {
                }
            }
            client.close();
            server.stop();
        } catch (MalformedURLException e) {
            System.out.println(">>> Skipping unsupported URL " + u);
            return true;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16852().handleNotification(n, o);
    }
}
