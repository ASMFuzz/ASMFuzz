import javax.net.*;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.net.*;
import java.util.*;

public class MyJVMTest_166 {

    static Set<CryptoPrimitive> primitives = new HashSet<CryptoPrimitive>();

    static String algorithm = "'$;2!rP!L=";

    static Key key = null;

    static AlgorithmParametersSpi parametersParam1 = null;

    static String parametersParam2Param1 = ":=3I\\Py0Y*";

    static double parametersParam2Param2 = 0d;

    static String parametersParam2Param3 = "WJsm&|!olr";

    static Provider parametersParam2 = new AuthProvider(parametersParam2Param1, parametersParam2Param2, parametersParam2Param3);

    static String parametersParam3 = "3Kf/c}<yO]";

    static AlgorithmParameters parameters = new AlgorithmParameters(parametersParam1, parametersParam2, parametersParam3);

    boolean test(String a) {
        return !a.toLowerCase().contains(alg.toLowerCase());
    }

    static String alg = ":Y$=bR]*|G";

    boolean permits(Set<CryptoPrimitive> primitives, String algorithm, Key key, AlgorithmParameters parameters) {
        return test(algorithm);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_166().permits(primitives, algorithm, key, parameters));
    }
}
