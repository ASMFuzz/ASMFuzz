import java.lang.management.*;
import javax.management.*;

public class MyJVMTest_16868 {

    static String got = "Xf0`%|]pAc";

    static String expect = "QpZf1UR&mk";

    static String failure = "wS$;)J(]yR";

    String check(String got, String expect) {
        if (!expect.equals(got)) {
            failure = "FAILED: got \"" + got + "\", expected \"" + expect + "\"";
            System.out.println(failure);
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16868().check(got, expect);
    }
}
