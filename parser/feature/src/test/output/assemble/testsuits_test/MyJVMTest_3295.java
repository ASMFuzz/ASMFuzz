import java.security.Provider;
import java.security.Security;
import java.security.AuthProvider;

public class MyJVMTest_3295 {

    static String pParam1 = "#QYHeJd^&I";

    static double pParam2 = Double.MIN_VALUE;

    static String pParam3 = "A&FPD1!QBC";

    static Provider p = new AuthProvider(pParam1, pParam2, pParam3);

    static int pos = 2;

    Provider setAt(Provider p, int pos) throws Exception {
        if (Security.getProvider(p.getName()) != null) {
            Security.removeProvider(p.getName());
        }
        if (Security.insertProviderAt(p, pos) == -1) {
            throw new Exception("cannot setAt");
        }
        return p;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3295().setAt(p, pos);
    }
}
