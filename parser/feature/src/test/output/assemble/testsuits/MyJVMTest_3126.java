public class MyJVMTest_3126 {

    static String methodName = "*ML~)H/]|Y";

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
        new MyJVMTest_3126().checkIAE(methodName, r);
    }
}
