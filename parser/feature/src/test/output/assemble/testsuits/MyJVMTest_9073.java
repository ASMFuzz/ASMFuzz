import java.io.*;
import java.util.*;

public class MyJVMTest_9073 {

    static String msg = "x'{}#R_Lz:";

    static int errors = 2;

    String error(String msg) {
        System.err.println("error: " + msg);
        errors++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9073().error(msg);
    }
}
