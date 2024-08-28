import java.net.*;
import java.io.*;
import java.util.*;
import java.security.*;

public class MyJVMTest_17104 {

    static int id = 0;

    static Socket clientSocket = null, serverSocket = null;

    static Thread out = null, in = null;

    static InputStream clientIn = null, serverIn = null;

    static OutputStream clientOut = null, serverOut = null;

    void awaitCompletion() {
        try {
            if (in != null)
                in.join();
            if (out != null)
                out.join();
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17104().awaitCompletion();
    }
}
