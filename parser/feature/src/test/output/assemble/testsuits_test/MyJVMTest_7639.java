import java.net.*;
import java.io.*;
import java.util.*;
import java.security.*;

public class MyJVMTest_7639 {

    static byte[] b = { 121, 77, 7, 83, 66, -38, -115, -118, -85, 94 };

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
        System.out.println(new MyJVMTest_7639().findCRLF(b));
    }
}
