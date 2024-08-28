import javax.management.*;
import javax.management.remote.*;
import java.net.MalformedURLException;

public class MyJVMTest_4081 {

    static String proto = ":0n2dk{\\r.";

    static MBeanServer mbs = null;

    boolean test(String proto, MBeanServer mbs) throws Exception {
        System.out.println("Test immediate client close for protocol " + proto);
        JMXServiceURL u = new JMXServiceURL(proto, null, 0);
        JMXConnectorServer s;
        try {
            s = JMXConnectorServerFactory.newJMXConnectorServer(u, null, mbs);
        } catch (MalformedURLException e) {
            System.out.println("Skipping unsupported URL " + u);
            return true;
        }
        s.start();
        JMXServiceURL a = s.getAddress();
        JMXConnector c = JMXConnectorFactory.newJMXConnector(a, null);
        c.close();
        s.stop();
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4081().test(proto, mbs));
    }
}
