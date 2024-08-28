import javax.management.*;
import java.util.concurrent.*;

public class MyJVMTest_11441 {

    static String nParam1 = "0*<(lU&n@{";

    static Object nParam2 = 3;

    static long nParam3 = 9223372036854775807L;

    static String nParam4Param1 = "P8,2CP q\"e";

    static ObjectName nParam4 = new ObjectName(nParam4Param1);

    static MBeanServerNotification n = new MBeanServerNotification(nParam1, nParam2, nParam3, nParam4);

    static String nameParam1 = "#~+#<B;Y7B";

    static ObjectName name = new ObjectName(nameParam1);

    static String type = "ZzqF/gu)-`";

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
        System.out.println(new MyJVMTest_11441().test(n, name));
    }
}
