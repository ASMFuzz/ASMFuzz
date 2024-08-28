import java.util.*;
import java.security.*;
import javax.crypto.*;

public class MyJVMTest_3251 {

    static String pParam1 = "?rBhDxVC`l";

    static double pParam2 = Double.MIN_VALUE;

    static String pParam3 = "Kl,th#9r/P";

    static Provider p = new AuthProvider(pParam1, pParam2, pParam3);

    Provider showProvider(Provider p) {
        System.out.println(p);
        for (Iterator t = p.getServices().iterator(); t.hasNext(); ) {
            System.out.println(t.next());
        }
        return p;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3251().showProvider(p);
    }
}
