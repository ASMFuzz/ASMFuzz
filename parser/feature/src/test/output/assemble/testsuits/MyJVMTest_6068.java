import javax.swing.*;
import java.io.*;

public class MyJVMTest_6068 {

    static String errorMsg = "L6)$@,?--A";

    static int pos = 3;

    static boolean failed = false;

    String handleError(String errorMsg, int pos) {
        failed = errorMsg.contains("eof.script");
        return errorMsg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6068().handleError(errorMsg, pos);
    }
}
