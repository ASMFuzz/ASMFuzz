import javax.net.*;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.net.*;
import java.util.*;

public class MyJVMTest_9315 {

    static Set<CryptoPrimitive> primitives = new HashSet<CryptoPrimitive>();

    static String algorithm = "S~Z!YK~P\\X";

    static Key key = null;

    static AlgorithmParametersSpi parametersParam1 = null;

    static String parametersParam2Param1 = "/F^YYbBmp+";

    static double parametersParam2Param2 = Double.POSITIVE_INFINITY;

    static String parametersParam2Param3 = "5+9f4Rfv]]";

    static Provider parametersParam2 = new AuthProvider(parametersParam2Param1, parametersParam2Param2, parametersParam2Param3);

    static String parametersParam3 = "[&MsB\"/I~e";

    static AlgorithmParameters parameters = new AlgorithmParameters(parametersParam1, parametersParam2, parametersParam3);

    boolean test(String a) {
        return !a.toLowerCase().contains(alg.toLowerCase());
    }

    static String alg = "EM}oyeZ4gb";

    boolean permits(Set<CryptoPrimitive> primitives, String algorithm, Key key, AlgorithmParameters parameters) {
        return test(algorithm);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9315().permits(primitives, algorithm, key, parameters));
    }
}
