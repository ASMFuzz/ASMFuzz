import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.security.*;
import java.util.*;

public class MyJVMTest_14731 {

    static boolean failed = false;

    static int pass = 0;

    boolean passed() {
        return !failed;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14731().passed());
    }
}
