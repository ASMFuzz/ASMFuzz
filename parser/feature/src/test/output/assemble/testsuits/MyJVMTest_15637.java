import javax.net.*;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.net.*;
import java.util.*;

public class MyJVMTest_15637 {

    static String alg = "!H<,^(wju/";

    static boolean signal = false;

    static int port = -1789762160;

    void waitForSignal() {
        while (!signal) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        signal = false;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15637().waitForSignal();
    }
}
