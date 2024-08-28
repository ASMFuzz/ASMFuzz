import javax.net.*;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.net.*;
import java.util.*;

public class MyJVMTest_7049 {

    static String alg = "E ac)pxP7L";

    static boolean signal = false;

    static int port = 704817639;

    void signal() {
        signal = true;
        notify();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7049().signal();
    }
}
