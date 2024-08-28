import java.net.*;
import java.util.*;
import java.io.*;
import javax.net.ssl.*;
import java.security.spec.*;
import java.security.interfaces.*;

public class MyJVMTest_15678 {

    static String[] args = { "FrzeKPP:u*", " UVk>hmn[5", "$p4xNWOA'/", "itgb}2:iuK", "k`U[t|}^Y*", ",U4zg,Uu;r", "UWvwOc|&1S", "`l1s9sJR[f", ":c%yUp|b[H", "4Y.tg3!,Q&" };

    static boolean separateServerThread = true;

    static String tmAlgorithm = "hQe-D2gHJt";

    static String enabledProtocol = "8-.!w;+[h4";

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    String[] parseArguments(String[] args) {
        tmAlgorithm = args[0];
        enabledProtocol = args[1];
        return args;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15678().parseArguments(args);
    }
}
