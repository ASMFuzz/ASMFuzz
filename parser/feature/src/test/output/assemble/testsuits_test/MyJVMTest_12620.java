import java.security.Provider;
import java.security.Security;
import java.security.AuthProvider;

public class MyJVMTest_12620 {

    static String pParam1 = "C6sv\"fs=XA";

    static double pParam2 = Double.NEGATIVE_INFINITY;

    static String pParam3 = "`t~~vJ!R3h";

    static Provider p = new AuthProvider(pParam1, pParam2, pParam3);

    static int pos = 4;

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
        new MyJVMTest_12620().setAt(p, pos);
    }
}
