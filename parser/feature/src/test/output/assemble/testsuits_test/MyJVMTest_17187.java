import java.net.*;
import java.io.*;
import java.util.*;
import java.security.*;

public class MyJVMTest_17187 {

    static byte[] b = { 109, -98, 54, 56, 58, 38, 25, -62, 108, 77 };

    static Socket clientSocket = null, serverSocket = null;

    static InputStream clientIn = null, serverIn = null;

    static OutputStream clientOut = null, serverOut = null;

    static int CR = 13;

    static int LF = 10;

    int findCRLF(byte[] b) {
        for (int i = 0; i < b.length - 1; i++) {
            if (b[i] == CR && b[i + 1] == LF) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17187().findCRLF(b));
    }
}
