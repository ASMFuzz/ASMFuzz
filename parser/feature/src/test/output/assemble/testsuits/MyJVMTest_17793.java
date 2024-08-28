import java.security.Policy;

public class MyJVMTest_17793 {

    static boolean hasSM = true;

    static Policy origPolicy = null;

    static String testName = "PY.S1kvURh";

    static String errMessage = "P,6,lR]A&,";

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
        new MyJVMTest_17793().tearDown();
    }
}
