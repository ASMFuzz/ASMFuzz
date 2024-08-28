import java.io.*;
import java.lang.annotation.*;

public class MyJVMTest_7576 {

    static String msg = "G)22Y~ 3sq";

    static int errors = 720759037;

    String error(String msg) {
        System.out.println("Error: " + msg);
        errors++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7576().error(msg);
    }
}
