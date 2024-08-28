import java.io.*;
import java.util.*;

public class MyJVMTest_18156 {

    static String msg = "m-!NlS^9YH";

    static String opt = "t}[ah|Q+Li";

    static int errors = 767271711;

    String error(String msg) {
        System.err.println("Error: " + msg);
        errors++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18156().error(msg);
    }
}
