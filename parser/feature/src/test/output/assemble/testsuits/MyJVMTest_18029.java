import java.lang.management.*;
import javax.management.*;
import static java.lang.management.ManagementFactory.*;

public class MyJVMTest_18029 {

    void printThreadInfo(ThreadInfo info) {
        if (info == null) {
            throw new RuntimeException("TEST FAILED: " + " Null ThreadInfo");
        }
        System.out.print(info.getThreadName());
        System.out.print(" id=" + info.getThreadId());
        System.out.println(" " + info.getThreadState());
        for (StackTraceElement s : info.getStackTrace()) {
            System.out.println(s);
        }
    }

    static ThreadMXBean thread = null;

    void checkThreadInfo() throws Exception {
        long[] ids = thread.getAllThreadIds();
        ThreadInfo[] infos = thread.getThreadInfo(ids);
        for (ThreadInfo ti : infos) {
            printThreadInfo(ti);
        }
        infos = thread.getThreadInfo(ids, 2);
        for (ThreadInfo ti : infos) {
            printThreadInfo(ti);
        }
        long id = Thread.currentThread().getId();
        ThreadInfo info = thread.getThreadInfo(id);
        printThreadInfo(info);
        info = thread.getThreadInfo(id, 2);
        printThreadInfo(info);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18029().checkThreadInfo();
    }
}
