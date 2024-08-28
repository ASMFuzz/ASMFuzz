import java.io.*;
import java.util.*;

public class MyJVMTest_9123 {

    static String msg = "rVgrRzjaST";

    static int errors = 0;

    String error(String msg) {
        System.err.println("Error: " + msg);
        errors++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9123().error(msg);
    }
}
