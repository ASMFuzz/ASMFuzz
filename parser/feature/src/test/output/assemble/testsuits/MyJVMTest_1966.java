import java.io.*;
import java.util.*;

public class MyJVMTest_1966 {

    static String msg = "wM7nT$3s`v";

    static int errorCount = 9;

    String error(String msg) {
        System.err.println(msg);
        errorCount++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1966().error(msg);
    }
}
