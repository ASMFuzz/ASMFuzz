import java.net.*;
import java.util.*;
import java.io.*;
import javax.net.ssl.*;
import java.security.spec.*;
import java.security.interfaces.*;

public class MyJVMTest_17320 {

    static String[] args = { "8,t6tYj)0]", "6qY~^yQ-j=", "BoHb*(;%Eb", "[gV*E)$#Wd", "H<~eMzFG{]", "eWEo ,n0Y(", "f=?kTV{nU^", "8RC[?;$[6i", "}~Izbzn>*r", "s_BA/'t 8t" };

    static boolean separateServerThread = true;

    static String tmAlgorithm = "Y=tnEQAXS/";

    static String disabledAlgorithms = "$H;)'~CIL?";

    static String cipherSuite = "KLo$\\E&O@X";

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    String[] parseArguments(String[] args) {
        tmAlgorithm = args[0];
        disabledAlgorithms = args[1];
        cipherSuite = args[2];
        return args;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17320().parseArguments(args);
    }
}
