import java.net.*;
import java.io.*;
import java.util.*;
import java.security.*;

public class MyJVMTest_7119 {

    static int id = 2;

    static Socket clientSocket = null, serverSocket = null;

    static Thread out = null, in = null;

    static InputStream clientIn = null, serverIn = null;

    static OutputStream clientOut = null, serverOut = null;

    boolean running() {
        return out.isAlive() || in.isAlive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7119().running());
    }
}
