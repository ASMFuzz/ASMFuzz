import java.net.*;
import java.nio.channels.*;

public class MyJVMTest_11207 {

    static String msg = "eBP#Cz?>_N";

    static InetAddress actual = null;

    static int failures = 0;

    InetAddress checkIsAnyLocalAddress(String msg, InetAddress actual) {
        System.out.format("%s actual: %s", msg, actual);
        if (actual.isAnyLocalAddress()) {
            System.out.println(" [PASS]");
        } else {
            System.out.println(" [FAIL]");
            failures++;
        }
        return actual;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11207().checkIsAnyLocalAddress(msg, actual);
    }
}
