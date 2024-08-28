import java.io.*;
import java.lang.annotation.*;

public class MyJVMTest_17119 {

    static String msg = "17F=^~ 8AX";

    static int errors = 5;

    String error(String msg) {
        System.out.println("Error: " + msg);
        errors++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17119().error(msg);
    }
}
