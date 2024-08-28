import javax.net.*;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.net.*;
import java.util.*;

public class MyJVMTest_8061 {

    static Set<CryptoPrimitive> primitives = new HashSet<CryptoPrimitive>();

    static String algorithm = "n<|^A?#[M/";

    static Key key = null;

    static AlgorithmParametersSpi parametersParam1 = null;

    static String parametersParam2Param1 = "JkBEc8e]%z";

    static double parametersParam2Param2 = Double.NEGATIVE_INFINITY;

    static String parametersParam2Param3 = "PH`#RqzZI:";

    static Provider parametersParam2 = new AuthProvider(parametersParam2Param1, parametersParam2Param2, parametersParam2Param3);

    static String parametersParam3 = "wBEg)T1Y|s";

    static AlgorithmParameters parameters = new AlgorithmParameters(parametersParam1, parametersParam2, parametersParam3);

    boolean test(String a) {
        return !a.toLowerCase().contains(alg.toLowerCase());
    }

    static String alg = "?kz'jUVqZ\\";

    static boolean go = true;

    static int port = 2;

    boolean permits(Set<CryptoPrimitive> primitives, String algorithm, Key key, AlgorithmParameters parameters) {
        return test(algorithm);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8061().permits(primitives, algorithm, key, parameters));
    }
}
