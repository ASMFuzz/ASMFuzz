import java.net.*;
import java.util.*;
import java.io.*;
import javax.net.ssl.*;
import java.security.spec.*;
import java.security.interfaces.*;

public class MyJVMTest_7766 {

    static String[] args = { "<2,9r{nM%|", "c5\"6HsKTWh", "*%;\"DQ=+a~", "+E fL+\"zQ2", "\\jw]9K>nyW", "*(/yVkZ9Iz", "b9-$i(sKI;", "btFQbc&_xl", "pl9lm6B-0T", "u[n$SCRT4h" };

    static boolean separateServerThread = true;

    static String tmAlgorithm = "uD~>:a@y;H";

    static String disabledAlgorithms = "1mW:6Cvj1>";

    static String cipherSuite = "=EC0!Jfl!9";

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
        new MyJVMTest_7766().parseArguments(args);
    }
}
