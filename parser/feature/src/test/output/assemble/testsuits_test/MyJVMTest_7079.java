import javax.security.auth.x500.X500Principal;

public class MyJVMTest_7079 {

    static String dnString = "wB#ygV;bKO";

    static int failed = 0;

    X500Principal parse(String dnString) throws Exception {
        System.out.println("Parsing " + dnString);
        X500Principal dn = new X500Principal(dnString);
        String dnString2 = dn.getName();
        X500Principal dn2 = new X500Principal(dnString2);
        if (dn.equals(dn2)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
            failed++;
        }
        return dn;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7079().parse(dnString);
    }
}
