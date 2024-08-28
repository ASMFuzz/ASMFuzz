import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.security.*;
import java.util.*;

public class MyJVMTest_11347 {

    static String output = "-UjhM{![+~";

    static boolean failed = false;

    String failed(String output) {
        failed = true;
        System.out.println("FAILED: " + output);
        return output;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11347().failed(output);
    }
}
