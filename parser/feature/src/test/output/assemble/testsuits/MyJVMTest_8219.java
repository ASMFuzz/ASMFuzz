import java.security.Policy;

public class MyJVMTest_8219 {

    static boolean hasSM = false;

    static Policy origPolicy = null;

    static String testName = "GZ 9Iu&k41";

    static String errMessage = "^D7@=uta`u";

    static int passed = 0, failed = 0;

    void tearDown() {
        System.setSecurityManager(null);
        Policy.setPolicy(origPolicy);
        if (hasSM) {
            System.setSecurityManager(new SecurityManager());
        }
        System.out.println("\nNumber of tests passed: " + passed);
        System.out.println("Number of tests failed: " + failed + "\n");
        if (errMessage != null) {
            throw new RuntimeException(errMessage);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8219().tearDown();
    }
}
