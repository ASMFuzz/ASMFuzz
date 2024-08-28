import javax.net.*;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.net.*;
import java.util.*;

public class MyJVMTest_12633 {

    static Set<CryptoPrimitive> primitives = new HashSet<CryptoPrimitive>();

    static String algorithm = "*''aVZ{l3<";

    static AlgorithmParametersSpi parametersParam1 = null;

    static String parametersParam2Param1 = "6ZjifEI]Iz";

    static double parametersParam2Param2 = Double.NEGATIVE_INFINITY;

    static String parametersParam2Param3 = "t({Cx7fali";

    static Provider parametersParam2 = new AuthProvider(parametersParam2Param1, parametersParam2Param2, parametersParam2Param3);

    static String parametersParam3 = "c<bf}o)/;6";

    static AlgorithmParameters parameters = new AlgorithmParameters(parametersParam1, parametersParam2, parametersParam3);

    boolean test(String a) {
        return !a.toLowerCase().contains(alg.toLowerCase());
    }

    static String alg = "Gwb_kb  cZ";

    boolean permits(Set<CryptoPrimitive> primitives, String algorithm, AlgorithmParameters parameters) {
        return test(algorithm);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12633().permits(primitives, algorithm, parameters));
    }
}
