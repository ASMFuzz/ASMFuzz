import javax.net.*;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.net.*;
import java.util.*;

public class MyJVMTest_3308 {

    static Set<CryptoPrimitive> primitives = new HashSet<CryptoPrimitive>();

    static String algorithm = ",h\\Ayf,\"I~";

    static AlgorithmParametersSpi parametersParam1 = null;

    static String parametersParam2Param1 = "%|?ogy*\\eK";

    static double parametersParam2Param2 = Double.MIN_VALUE;

    static String parametersParam2Param3 = "7UFb{#96QI";

    static Provider parametersParam2 = new AuthProvider(parametersParam2Param1, parametersParam2Param2, parametersParam2Param3);

    static String parametersParam3 = "G2Ut[lu9$_";

    static AlgorithmParameters parameters = new AlgorithmParameters(parametersParam1, parametersParam2, parametersParam3);

    boolean test(String a) {
        return !a.toLowerCase().contains(alg.toLowerCase());
    }

    static String alg = "z><(pyH&\"^";

    boolean permits(Set<CryptoPrimitive> primitives, String algorithm, AlgorithmParameters parameters) {
        return test(algorithm);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3308().permits(primitives, algorithm, parameters));
    }
}
