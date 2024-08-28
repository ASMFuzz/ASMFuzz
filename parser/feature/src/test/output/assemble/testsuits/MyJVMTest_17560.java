import java.io.*;
import java.net.*;
import java.util.*;

public class MyJVMTest_17560 {

    static String message = "y[IAf140%7";

    static int errors = 0;

    String error(String message) {
        System.err.println("Error: " + message);
        errors++;
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17560().error(message);
    }
}
