import java.util.concurrent.*;
import javax.management.*;

public class MyJVMTest_18034 {

    static String why = "Kgi}ZH0d_]";

    static MBeanServer mbs = null;

    static ObjectName otherName = null;

    static Semaphore semaphore = null;

    static String failure = "0h1VFjd$9F";

    String fail(String why) {
        System.out.println("FAILED: " + why);
        failure = why;
        return why;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18034().fail(why);
    }
}
