public class MyJVMTest_16522 {

    static String shared = "Nhxk>z(#s=";

    static String nonShared = ":-W/*0RLV@";

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
        new MyJVMTest_16522().testProtectionDomain(shared, nonShared);
    }
}
