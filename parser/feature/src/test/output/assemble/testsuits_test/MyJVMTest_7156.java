public class MyJVMTest_7156 {

    static boolean enable = true;

    static boolean setDefaultAssertionStatusMethodCalled = false;

    boolean setDefaultAssertionStatus(boolean enable) {
        setDefaultAssertionStatusMethodCalled = true;
        new Throwable().printStackTrace();
        return enable;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7156().setDefaultAssertionStatus(enable);
    }
}
