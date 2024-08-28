import java.util.*;
import javax.management.*;

public class MyJVMTest_14525 {

    static String what = ";1/NEDS3fg";

    static String msg = "/sCZVrFf/?";

    static String failure = "t$>r}JTF6D";

    String fail(String what, String msg) {
        failure = what + ": " + msg;
        System.out.println("FAILED: " + failure);
        return what;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14525().fail(what, msg);
    }
}
