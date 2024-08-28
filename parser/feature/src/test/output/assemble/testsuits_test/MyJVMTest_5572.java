import java.lang.management.*;
import javax.management.*;
import static java.lang.management.ManagementFactory.*;

public class MyJVMTest_5572 {

    static ThreadMXBean mbean = null;

    static ThreadMXBean proxy = null;

    static MBeanServer mbs = null;

    static String onParam1 = "h-;f/@HW98";

    static ObjectName on = new ObjectName(onParam1);

    ThreadInfo[] checkNullElement(ThreadMXBean mbean, ThreadMXBean proxy, MBeanServer mbs, ObjectName on) throws Exception {
        System.out.println("--- Check null element");
        long[] ids = { new Thread().getId() };
        ThreadInfo[] tinfos = mbean.getThreadInfo(ids);
        if (tinfos[0] != null) {
            throw new RuntimeException("TEST FAILED: " + "Expected to have a null element");
        }
        Object[] params = { ids };
        String[] sigs = { "[J" };
        Object[] result = (Object[]) mbs.invoke(on, "getThreadInfo", params, sigs);
        if (result[0] != null) {
            throw new RuntimeException("TEST FAILED: " + "Expected to have a null element via MBeanServer");
        }
        tinfos = proxy.getThreadInfo(ids);
        if (tinfos[0] != null) {
            throw new RuntimeException("TEST FAILED: " + "Expected to have a null element");
        }
        System.out.println("--- PASSED");
        return tinfos;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5572().checkNullElement(mbean, proxy, mbs, on);
    }
}
