import java.security.*;
import java.security.Provider.*;

public class MyJVMTest_1803 {

    static String pParam1 = "dv1kS(Y,L;";

    static double pParam2 = Double.NEGATIVE_INFINITY;

    static String pParam3 = "id#/L.AS=w";

    static Provider p = new AuthProvider(pParam1, pParam2, pParam3);

    static String type = "Bdd^7%(wB*";

    static String alg = "b].Ica`%XG";

    Service testService(Provider p, String type, String alg) throws Exception {
        System.out.println("Getting " + type + "." + alg + "...");
        Service s = p.getService(type, alg);
        System.out.println(s);
        if (s == null) {
            throw new Exception("Lookup failed for: " + type + "." + alg);
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1803().testService(p, type, alg));
    }
}
