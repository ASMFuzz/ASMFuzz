import javax.net.*;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.net.*;
import java.util.*;

public class MyJVMTest_2672 {

    static String alg = "bJ&pjpGnS)";

    static boolean signal = false;

    void waitForSignal() {
        while (!signal) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        signal = false;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2672().waitForSignal();
    }
}
