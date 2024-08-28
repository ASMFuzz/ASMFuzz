public class MyJVMTest_11923 {

    static String errMsg = " b;\\\";bJ}N";

    static int passed = 0, failed = 0;

    void tearDown() {
        System.out.println("\nNumber of tests passed: " + passed);
        System.out.println("Number of tests failed: " + failed + "\n");
        if (errMsg != null) {
            throw new RuntimeException(errMsg);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11923().tearDown();
    }
}
