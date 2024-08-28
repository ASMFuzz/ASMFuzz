import java.io.*;
import java.lang.management.*;
import javax.management.*;
import javax.management.openmbean.*;

public class MyJVMTest_8353 {

    static MBeanServer mbs = null;

    static String onParam1 = "2\"u1\\%ne{0";

    static ObjectName on = new ObjectName(onParam1);

    void echo(String msg) {
        System.out.println(msg);
    }

    static MBeanNotificationInfo[] notifs = new MBeanNotificationInfo[] { new MBeanNotificationInfo(new String[] { AttributeChangeNotification.ATTRIBUTE_CHANGE }, AttributeChangeNotification.class.getName(), "This notification is emitted when the reset() method is called.") };

    static String state = "initial state";

    static int nbChanges = 0;

    ObjectName printAttributes(MBeanServer mbs, ObjectName on) throws Exception {
        echo("\n    Getting attribute values:");
        String state = (String) mbs.getAttribute(on, "State");
        Integer nbChanges = (Integer) mbs.getAttribute(on, "NbChanges");
        echo("\tState     = \"" + state + "\"");
        echo("\tNbChanges = " + nbChanges);
        String type = on.getKeyProperty("type");
        if (type.indexOf("Test2") != -1 || type.indexOf("Test4") != -1) {
            CompositeData memoryUsage = (CompositeData) mbs.getAttribute(on, "MemoryUsage");
            echo("\tMemoryUsage = " + memoryUsage);
        } else {
            MemoryUsage memoryUsage = (MemoryUsage) mbs.getAttribute(on, "MemoryUsage");
            echo("\tMemoryUsage = " + memoryUsage);
        }
        return on;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8353().printAttributes(mbs, on);
    }
}
