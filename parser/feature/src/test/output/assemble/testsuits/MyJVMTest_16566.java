import javax.net.*;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.net.*;
import java.util.*;

public class MyJVMTest_16566 {

    static String alg = "dmOQK0=k*e";

    static boolean signal = false;

    static int port = 229597738;

    void signal() {
        signal = true;
        notify();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16566().signal();
    }
}
