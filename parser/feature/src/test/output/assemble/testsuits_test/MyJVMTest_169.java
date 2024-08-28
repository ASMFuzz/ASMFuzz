import javax.net.*;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.net.*;
import java.util.*;

public class MyJVMTest_169 {

    static boolean signal = false;

    static int port = 2;

    void signal() {
        signal = true;
        notify();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_169().signal();
    }
}
