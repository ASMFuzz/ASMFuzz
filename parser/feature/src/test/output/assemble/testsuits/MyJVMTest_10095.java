import javax.net.*;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.net.*;
import java.util.*;

public class MyJVMTest_10095 {

    static Set<CryptoPrimitive> primitives = new HashSet<CryptoPrimitive>();

    static String algorithm = "I|@!tWW%&{";

    static AlgorithmParametersSpi parametersParam1 = null;

    static String parametersParam2Param1 = "C8WgKpu^W\\";

    static double parametersParam2Param2 = 0d;

    static String parametersParam2Param3 = "^c)P#W4%m&";

    static Provider parametersParam2 = new AuthProvider(parametersParam2Param1, parametersParam2Param2, parametersParam2Param3);

    static String parametersParam3 = "0r9Q/G&Oz,";

    static AlgorithmParameters parameters = new AlgorithmParameters(parametersParam1, parametersParam2, parametersParam3);

    boolean test(String a) {
        return !a.toLowerCase().contains(alg.toLowerCase());
    }

    static String alg = "x*bt~8%$g]";

    static boolean go = true;

    boolean permits(Set<CryptoPrimitive> primitives, String algorithm, AlgorithmParameters parameters) {
        return test(algorithm);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10095().permits(primitives, algorithm, parameters));
    }
}
