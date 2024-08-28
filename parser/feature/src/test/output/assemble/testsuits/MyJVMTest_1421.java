import java.io.*;
import static java.lang.System.*;

public class MyJVMTest_1421 {

    static String failureMsg = "R]#yB=K{KU";

    static int failures = 0;

    String fail(String failureMsg) {
        System.out.println(failureMsg);
        failures++;
        return failureMsg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1421().fail(failureMsg);
    }
}
