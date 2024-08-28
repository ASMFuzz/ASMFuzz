import java.net.*;
import java.util.*;
import java.io.*;
import javax.net.ssl.*;
import java.security.spec.*;
import java.security.interfaces.*;

public class MyJVMTest_7833 {

    static String[] args = { "c+ b7?iU8T", "dMlh7N<X`O", "r\"v^y+Y8Uw", "H<L>%bXY9E", "i]$Gz[SzH?", "LYL(o[*U1R", "($|*5G<hI2", "7K<T 7lk=<", "kC%E_]ZW ,", "|*q XFgW[X" };

    static boolean separateServerThread = false;

    static String tmAlgorithm = "1Q]YZ73czn";

    static String clientRequestedHostname = ".62Gp?AH|k";

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
        new MyJVMTest_7833().parseArguments(args);
    }
}
