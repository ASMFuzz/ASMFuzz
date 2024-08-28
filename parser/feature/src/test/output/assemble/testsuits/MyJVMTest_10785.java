public class MyJVMTest_10785 {

    static String methodName = "kzl'ML`ZAP";

    static Runnable r = () -> {
    };

    String checkOOM(String methodName, Runnable r) {
        try {
            r.run();
            throw new RuntimeException("OutOfMemoryError should have been thrown by: " + methodName);
        } catch (OutOfMemoryError er) {
        }
        return methodName;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10785().checkOOM(methodName, r);
    }
}
