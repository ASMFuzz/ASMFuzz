import java.net.*;
import java.util.*;
import java.io.*;
import javax.net.ssl.*;
import java.security.spec.*;
import java.security.interfaces.*;

public class MyJVMTest_11879 {

    static String[] args = { "~\\Jq&{8.3V", "QdfV(vP8[!", "m;,(oGTj }", "kK6gAX!W1 ", "irB<%)Rle$", "^BX0F,J[mi", ")iY)hgC!)x", "xuX_)!t$lO", "2m=K@PZ:vY", "kxgHv']%.e" };

    static boolean separateServerThread = true;

    static String tmAlgorithm = "MTrYJv]~`?";

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    String[] parseArguments(String[] args) {
        tmAlgorithm = args[0];
        return args;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11879().parseArguments(args);
    }
}
