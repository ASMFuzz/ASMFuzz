import javax.net.*;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.net.*;
import java.util.*;

public class MyJVMTest_9319 {

    static boolean signal = false;

    static int port = 0;

    void signal() {
        signal = true;
        notify();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9319().signal();
    }
}
