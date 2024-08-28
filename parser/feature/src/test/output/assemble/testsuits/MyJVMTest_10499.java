import java.util.*;
import javax.management.*;

public class MyJVMTest_10499 {

    static String msg = "k6Tiw^M%Y6";

    static String failure = "eTM{3Kko<C";

    String fail(String msg) {
        System.out.println("FAILED: " + msg);
        failure = msg;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10499().fail(msg);
    }
}
