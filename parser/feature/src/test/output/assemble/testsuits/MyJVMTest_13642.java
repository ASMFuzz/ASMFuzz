import javax.net.*;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.net.*;
import java.util.*;

public class MyJVMTest_13642 {

    static Set<CryptoPrimitive> primitives = new HashSet<CryptoPrimitive>();

    static String algorithm = "}=ojU{?=m;";

    static AlgorithmParametersSpi parametersParam1 = null;

    static String parametersParam2Param1 = "\"A@3$|>4av";

    static double parametersParam2Param2 = 0.3780203035763703;

    static String parametersParam2Param3 = "XLhhd0N\"W5";

    static Provider parametersParam2 = new AuthProvider(parametersParam2Param1, parametersParam2Param2, parametersParam2Param3);

    static String parametersParam3 = ")7$EW=,ZJt";

    static AlgorithmParameters parameters = new AlgorithmParameters(parametersParam1, parametersParam2, parametersParam3);

    boolean test(String a) {
        return !a.toLowerCase().contains(alg.toLowerCase());
    }

    static String alg = "4~Z&xF9y:F";

    static boolean go = true;

    static int port = 372481988;

    boolean permits(Set<CryptoPrimitive> primitives, String algorithm, AlgorithmParameters parameters) {
        return test(algorithm);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13642().permits(primitives, algorithm, parameters));
    }
}
