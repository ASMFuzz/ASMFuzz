import javax.net.*;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.net.*;
import java.util.*;

public class MyJVMTest_15843 {

    static boolean signal = false;

    void signal() {
        signal = true;
        notify();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15843().signal();
    }
}
