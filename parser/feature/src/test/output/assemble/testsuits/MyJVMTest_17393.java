import java.net.*;
import java.util.*;
import java.io.*;
import javax.net.ssl.*;
import java.security.spec.*;
import java.security.interfaces.*;

public class MyJVMTest_17393 {

    static String[] args = { "WZlk<c-`6t", "ip40J=`x*I", "%_}\\y6\\uMA", "3:COH_Rt\\)", "u+I,/]2nei", "$M<F!LiM<@", "d]tvBOKnut", ".b=bnD{N+(", "6HkxMGh!jU", "#]s=8][|OT" };

    static boolean separateServerThread = false;

    static String tmAlgorithm = "F;6H,BRk:`";

    static String clientRequestedHostname = "NX|\\|4u%%z";

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    String[] parseArguments(String[] args) {
        tmAlgorithm = args[0];
        clientRequestedHostname = args[1];
        return args;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17393().parseArguments(args);
    }
}
