import java.lang.management.*;
import java.util.*;
import javax.management.*;
import javax.management.remote.*;

public class MyJVMTest_4374 {

    static String description = "qfh?e1L9kC";

    int countTimeoutThreads() {
        ThreadMXBean mb = ManagementFactory.getThreadMXBean();
        int count = 0;
        long[] ids = mb.getAllThreadIds();
        for (ThreadInfo ti : mb.getThreadInfo(ids)) {
            if (ti != null && ti.getThreadName().startsWith("JMX server connection timeout"))
                count++;
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4374().countTimeoutThreads());
    }
}
