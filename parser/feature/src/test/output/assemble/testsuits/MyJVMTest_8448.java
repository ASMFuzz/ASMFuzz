import java.util.concurrent.*;
import javax.management.*;

public class MyJVMTest_8448 {

    static String why = "~l.T`\\H#b!";

    static MBeanServer mbs = null;

    static ObjectName otherName = null;

    static Semaphore semaphore = null;

    static String failure = "?gG%k} M]$";

    String fail(String why) {
        System.out.println("FAILED: " + why);
        failure = why;
        return why;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8448().fail(why);
    }
}
