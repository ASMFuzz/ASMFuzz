import java.util.*;
import javax.management.*;

public class MyJVMTest_5111 {

    static String what = ")2er.mFi}0";

    static String msg = "!2kB4]F\\\"/";

    static String failure = " z$:r^3m@;";

    String fail(String what, String msg) {
        failure = what + ": " + msg;
        System.out.println("FAILED: " + failure);
        return what;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5111().fail(what, msg);
    }
}
