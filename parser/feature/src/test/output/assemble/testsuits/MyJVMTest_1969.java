import java.net.*;
import java.nio.channels.*;

public class MyJVMTest_1969 {

    static String msg = "!6E^?*eMe|";

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
        new MyJVMTest_1969().checkIsAnyLocalAddress(msg, actual);
    }
}
