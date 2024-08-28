public class MyJVMTest_10176 {

    static boolean isPasswordField = true;

    static boolean isIntMethodCalled = false;

    static boolean isFPMethodCalled = false;

    boolean getResult() {
        return !isIntMethodCalled && isFPMethodCalled;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10176().getResult());
    }
}
