public class MyJVMTest_7007 {

    static String shared = "r1\".4Q\\8rj";

    static String nonShared = "nSJR*V`Oo|";

    Class testProtectionDomain(String shared, String nonShared) throws Throwable {
        Class c1 = Class.forName(shared);
        Class c2 = Class.forName(nonShared);
        if (c1.getProtectionDomain() != c2.getProtectionDomain()) {
            System.out.println(c1.getProtectionDomain());
            System.out.println(c1.getProtectionDomain().getCodeSource());
            System.out.println(c2.getProtectionDomain());
            System.out.println(c2.getProtectionDomain().getCodeSource());
            throw new RuntimeException("Failed: Protection Domains do not match!");
        } else {
            System.out.println(c1.getProtectionDomain());
            System.out.println(c1.getProtectionDomain().getCodeSource());
            System.out.println(c2.getProtectionDomain());
            System.out.println(c2.getProtectionDomain().getCodeSource());
            System.out.println("Passed: Protection Domains match.");
        }
        return c2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7007().testProtectionDomain(shared, nonShared);
    }
}
