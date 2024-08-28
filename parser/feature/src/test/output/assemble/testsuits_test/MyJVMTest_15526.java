import javax.swing.*;
import java.io.*;

public class MyJVMTest_15526 {

    static String errorMsg = "<V'LIZ>M]_";

    static int pos = -602445355;

    static boolean failed = false;

    String handleError(String errorMsg, int pos) {
        failed = errorMsg.contains("eof.script");
        return errorMsg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15526().handleError(errorMsg, pos);
    }
}
