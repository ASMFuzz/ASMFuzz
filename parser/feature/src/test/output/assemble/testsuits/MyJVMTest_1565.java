public class MyJVMTest_1565 {

    static String methodName = "}8 ;Il9MZH";

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
        new MyJVMTest_1565().checkOOM(methodName, r);
    }
}
