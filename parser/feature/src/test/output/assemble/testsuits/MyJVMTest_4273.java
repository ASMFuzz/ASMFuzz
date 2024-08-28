import javax.net.*;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.net.*;
import java.util.*;

public class MyJVMTest_4273 {

    static Set<CryptoPrimitive> primitives = new HashSet<CryptoPrimitive>();

    static String algorithm = "InHoOLu68[";

    static AlgorithmParametersSpi parametersParam1 = null;

    static String parametersParam2Param1 = "C/E[{cKTOk";

    static double parametersParam2Param2 = 0.9388222075515361;

    static String parametersParam2Param3 = "q%yfVf1-$[";

    static Provider parametersParam2 = new AuthProvider(parametersParam2Param1, parametersParam2Param2, parametersParam2Param3);

    static String parametersParam3 = ")3D_z'*F~w";

    static AlgorithmParameters parameters = new AlgorithmParameters(parametersParam1, parametersParam2, parametersParam3);

    boolean test(String a) {
        return !a.toLowerCase().contains(alg.toLowerCase());
    }

    static String alg = "?s8WN\"*JzS";

    static boolean go = true;

    static int port = 0;

    boolean permits(Set<CryptoPrimitive> primitives, String algorithm, AlgorithmParameters parameters) {
        return test(algorithm);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4273().permits(primitives, algorithm, parameters));
    }
}
