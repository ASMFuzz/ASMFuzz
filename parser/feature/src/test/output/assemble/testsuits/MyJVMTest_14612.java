public class MyJVMTest_14612 {

    static boolean condition = true;

    static String methodName = "qE\"6V_FboH";

    String check(boolean condition, String methodName) {
        if (!condition) {
            throw new RuntimeException(methodName + " failed");
        }
        return methodName;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14612().check(condition, methodName);
    }
}
