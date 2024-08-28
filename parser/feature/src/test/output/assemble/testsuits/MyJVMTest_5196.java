public class MyJVMTest_5196 {

    static boolean condition = false;

    static String methodName = "xSnqUEDHI|";

    String check(boolean condition, String methodName) {
        if (!condition) {
            throw new RuntimeException(methodName + " failed");
        }
        return methodName;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5196().check(condition, methodName);
    }
}
