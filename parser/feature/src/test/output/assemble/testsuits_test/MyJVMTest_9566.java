import java.lang.management.*;
import javax.management.*;
import static java.lang.management.ManagementFactory.*;

public class MyJVMTest_9566 {

    static ThreadInfo info = null;

    ThreadInfo printThreadInfo(ThreadInfo info) {
        if (info == null) {
            throw new RuntimeException("TEST FAILED: " + " Null ThreadInfo");
        }
        System.out.print(info.getThreadName());
        System.out.print(" id=" + info.getThreadId());
        System.out.println(" " + info.getThreadState());
        for (StackTraceElement s : info.getStackTrace()) {
            System.out.println(s);
        }
        return info;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9566().printThreadInfo(info);
    }
}
