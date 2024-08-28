import java.lang.management.*;
import java.util.*;
import javax.management.*;
import static java.lang.management.ManagementFactory.*;

public class MyJVMTest_11344 {

    static T obj = null;

    static MBeanServerConnection mbs = null;

    static Class<T> mxbeanInterface = null;

    static String mxbeanName = "bA(!9onTla";

    <T extends PlatformManagedObject> PlatformManagedObject checkRemotePlatformMXBean(T obj, MBeanServerConnection mbs, Class<T> mxbeanInterface, String mxbeanName) throws Exception {
        PlatformManagedObject mxbean = getPlatformMXBean(mbs, mxbeanInterface);
        if ((obj == null && mxbean != null) || (obj != null && mxbean == null)) {
            throw new RuntimeException("Singleton MXBean returned not matched");
        }
        int numElements = obj == null ? 0 : 1;
        List<? extends PlatformManagedObject> mxbeans = getPlatformMXBeans(mbs, mxbeanInterface);
        if (mxbeans.size() != numElements) {
            throw new RuntimeException("Unmatched number of platform MXBeans " + mxbeans.size() + ". Expected = " + numElements);
        }
        ObjectName on = new ObjectName(mxbeanName);
        if (!on.equals(mxbean.getObjectName())) {
            throw new RuntimeException("Unmatched ObjectName " + mxbean.getObjectName() + " Expected = " + on);
        }
        return mxbean;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11344().checkRemotePlatformMXBean(obj, mbs, mxbeanInterface, mxbeanName);
    }
}
