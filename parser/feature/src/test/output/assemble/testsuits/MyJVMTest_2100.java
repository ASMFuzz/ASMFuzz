import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.security.*;
import java.util.*;

public class MyJVMTest_2100 {

    static String output = "Lfr3rwtiba";

    static boolean failed = false;

    String failed(String output) {
        failed = true;
        System.out.println("FAILED: " + output);
        return output;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2100().failed(output);
    }
}
