public class MyJVMTest_12441 {

    static String methodName = "1@1`)gr=vc";

    static Runnable r = () -> {
    };

    String checkIAE(String methodName, Runnable r) {
        try {
            r.run();
            throw new RuntimeException("IllegalArgumentException should have been thrown by: " + methodName);
        } catch (IllegalArgumentException iae) {
        }
        return methodName;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12441().checkIAE(methodName, r);
    }
}
