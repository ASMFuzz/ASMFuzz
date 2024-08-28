import javax.net.*;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.net.*;
import java.util.*;

public class MyJVMTest_914 {

    static Set<CryptoPrimitive> primitives = new HashSet<CryptoPrimitive>();

    static String algorithm = "rxh;\\pKpBm";

    static AlgorithmParametersSpi parametersParam1 = null;

    static String parametersParam2Param1 = "\\J$V:a:)\\]";

    static double parametersParam2Param2 = Double.NaN;

    static String parametersParam2Param3 = "7Jb6$gjbMZ";

    static Provider parametersParam2 = new AuthProvider(parametersParam2Param1, parametersParam2Param2, parametersParam2Param3);

    static String parametersParam3 = "w#\\f!hnj9g";

    static AlgorithmParameters parameters = new AlgorithmParameters(parametersParam1, parametersParam2, parametersParam3);

    boolean test(String a) {
        return !a.toLowerCase().contains(alg.toLowerCase());
    }

    static String alg = "CR;nmrI?OI";

    static boolean go = true;

    boolean permits(Set<CryptoPrimitive> primitives, String algorithm, AlgorithmParameters parameters) {
        return test(algorithm);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_914().permits(primitives, algorithm, parameters));
    }
}
