import javax.management.*;
import javax.management.remote.*;
import java.net.MalformedURLException;

public class MyJVMTest_13440 {

    static String proto = "uRG~;gdiQS";

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
        System.out.println(new MyJVMTest_13440().test(proto, mbs));
    }
}
