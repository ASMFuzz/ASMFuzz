import java.lang.management.*;
import javax.management.*;

public class MyJVMTest_7341 {

    static String got = "Qsl16=\"xj8";

    static String expect = "\\Fz#! )i?W";

    static String failure = "vKun.\\:K(x";

    String check(String got, String expect) {
        if (!expect.equals(got)) {
            failure = "FAILED: got \"" + got + "\", expected \"" + expect + "\"";
            System.out.println(failure);
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7341().check(got, expect);
    }
}
