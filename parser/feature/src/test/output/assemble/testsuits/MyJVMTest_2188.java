import javax.management.*;
import java.util.concurrent.*;

public class MyJVMTest_2188 {

    static MBeanServerNotification n = null;

    static ObjectName name = null;

    static String type = "'HclpSw#B,";

    int test(MBeanServerNotification n, ObjectName name) {
        int failures = 0;
        System.out.println("Testing: " + n);
        if (!n.toString().endsWith("[type=" + type + "][message=" + n.getMessage() + "][mbeanName=" + name + "]")) {
            System.err.println("Test failed for " + type + " [" + name + "]: " + n);
            failures++;
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2188().test(n, name));
    }
}
