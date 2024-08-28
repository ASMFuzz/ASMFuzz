public class MyJVMTest_5910 {

    static String shared = "Y[@^SFm AM";

    static String nonShared = "@2Ih~=_uhi";

    Class testProtectionDomain(String shared, String nonShared) throws Throwable {
        Class c1 = Class.forName(shared);
        Class c2 = Class.forName(nonShared);
        if (c1.getProtectionDomain() != c2.getProtectionDomain()) {
            System.out.println("Failed: Protection Domains do not match!");
            System.out.println(c1.getProtectionDomain());
            System.out.println(c1.getProtectionDomain().getCodeSource());
            System.out.println(c2.getProtectionDomain());
            System.out.println(c2.getProtectionDomain().getCodeSource());
            System.exit(1);
        } else {
            System.out.println("Passed: Protection Domains match.");
        }
        return c2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5910().testProtectionDomain(shared, nonShared);
    }
}
