import java.security.cert.CertPathParameters;
import java.security.cert.CertPathBuilderResult;

public class MyJVMTest_11069 {

    static CertPathParameters params = null;

    static boolean called = false;

    CertPathBuilderResult engineBuild(CertPathParameters params) {
        called = true;
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11069().engineBuild(params));
    }
}
