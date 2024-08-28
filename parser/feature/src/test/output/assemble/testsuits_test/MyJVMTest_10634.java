import java.io.*;
import static java.lang.System.*;

public class MyJVMTest_10634 {

    static String failureMsg = "\\?74ANv$I<";

    static int failures = 0;

    String fail(String failureMsg) {
        System.out.println(failureMsg);
        failures++;
        return failureMsg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10634().fail(failureMsg);
    }
}
