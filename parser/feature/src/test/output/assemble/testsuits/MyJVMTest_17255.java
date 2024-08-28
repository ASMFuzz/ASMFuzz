import javax.net.*;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.net.*;
import java.util.*;

public class MyJVMTest_17255 {

    static String alg = "6'J$iLT}d%";

    static boolean signal = false;

    void signal() {
        signal = true;
        notify();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17255().signal();
    }
}
