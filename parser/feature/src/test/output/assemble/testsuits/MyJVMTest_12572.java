import java.util.*;
import java.security.*;
import javax.crypto.*;

public class MyJVMTest_12572 {

    static String pParam1 = "\\=c;b2h(%!";

    static double pParam2 = Double.NEGATIVE_INFINITY;

    static String pParam3 = "PK!hV.#}96";

    static Provider p = new AuthProvider(pParam1, pParam2, pParam3);

    Provider showProvider(Provider p) {
        System.out.println(p);
        for (Iterator t = p.getServices().iterator(); t.hasNext(); ) {
            System.out.println(t.next());
        }
        return p;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12572().showProvider(p);
    }
}
