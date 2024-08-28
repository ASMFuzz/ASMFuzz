import java.net.*;
import java.io.*;
import java.util.*;
import java.security.*;

public class MyJVMTest_16638 {

    static int id = 0;

    static Socket clientSocket = null, serverSocket = null;

    static Thread out = null, in = null;

    static InputStream clientIn = null, serverIn = null;

    static OutputStream clientOut = null, serverOut = null;

    boolean running() {
        return out.isAlive() || in.isAlive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16638().running());
    }
}
