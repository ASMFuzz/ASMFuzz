import java.security.*;
import java.security.Provider.*;

public class MyJVMTest_11028 {

    static String pParam1 = "T\\+Ex6*R>T";

    static double pParam2 = 0.8497719553896942;

    static String pParam3 = "XWds8H$c-&";

    static Provider p = new AuthProvider(pParam1, pParam2, pParam3);

    static String type = "G\\],h{|oJp";

    static String alg = "pUJw45Gm/;";

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
        System.out.println(new MyJVMTest_11028().testService(p, type, alg));
    }
}
