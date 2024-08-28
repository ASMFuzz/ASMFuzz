import java.lang.management.*;
import java.util.*;
import javax.management.*;
import static java.lang.management.ManagementFactory.*;

public class MyJVMTest_15854 {

    static List<T> objs = new ArrayList<T>();

    static Class<T> mxbeanInterface = null;

    static MBeanServer platformMBeanServer = getPlatformMBeanServer();

    <T extends PlatformManagedObject> List<? extends PlatformManagedObject> checkPlatformMXBeans(List<T> objs, Class<T> mxbeanInterface) throws Exception {
        try {
            getPlatformMXBean(mxbeanInterface);
            throw new RuntimeException(mxbeanInterface + ": not a singleton MXBean");
        } catch (IllegalArgumentException e) {
        }
        List<? extends PlatformManagedObject> mxbeans = getPlatformMXBeans(mxbeanInterface);
        if (objs.size() != mxbeans.size()) {
            throw new RuntimeException("Unmatched number of platform MXBeans " + mxbeans.size() + ". Expected = " + objs.size());
        }
        List<T> list = new ArrayList<T>(objs);
        for (PlatformManagedObject pmo : mxbeans) {
            if (list.contains(pmo)) {
                list.remove(pmo);
            } else {
                throw new RuntimeException(pmo + " not in the platform MXBean list");
            }
        }
        if (!list.isEmpty()) {
            throw new RuntimeException("The list returned by getPlatformMXBeans" + " not matched");
        }
        mxbeans = getPlatformMXBeans(platformMBeanServer, mxbeanInterface);
        if (objs.size() != mxbeans.size()) {
            throw new RuntimeException("Unmatched number of platform MXBeans " + mxbeans.size() + ". Expected = " + objs.size());
        }
        return mxbeans;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15854().checkPlatformMXBeans(objs, mxbeanInterface);
    }
}
