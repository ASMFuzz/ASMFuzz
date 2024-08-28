import java.net.*;
import java.util.*;
import java.io.*;
import javax.net.ssl.*;
import java.security.spec.*;
import java.security.interfaces.*;

public class MyJVMTest_2599 {

    static String[] args = { "6INmWEcNnM", "lj4OL+vkGj", "^g#x<#<uZ@", "5pT,1qSe})", "vl5NjF(f;H", "wWBV$sN|se", "rw!JnUx){?", "n@6RXB&z*0", " M*_i'X>Z8", "&`}Gnxsw~R" };

    static boolean separateServerThread = true;

    static String tmAlgorithm = ",D?'`x3#mY";

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    String[] parseArguments(String[] args) {
        tmAlgorithm = args[0];
        return args;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2599().parseArguments(args);
    }
}
