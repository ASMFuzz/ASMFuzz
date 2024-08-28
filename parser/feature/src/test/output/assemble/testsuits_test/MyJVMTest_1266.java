import javax.net.*;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.net.*;
import java.util.*;

public class MyJVMTest_1266 {

    static boolean signal = false;

    static int port = 0;

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
        new MyJVMTest_1266().waitForSignal();
    }
}
