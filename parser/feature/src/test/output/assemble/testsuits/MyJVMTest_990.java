public class MyJVMTest_990 {

    static boolean isPasswordField = true;

    static boolean isIntMethodCalled = false;

    static boolean isFPMethodCalled = false;

    boolean getResult() {
        return !isIntMethodCalled && isFPMethodCalled;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_990().getResult());
    }
}
