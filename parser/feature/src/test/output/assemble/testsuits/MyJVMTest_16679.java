public class MyJVMTest_16679 {

    static boolean enable = false;

    static boolean setDefaultAssertionStatusMethodCalled = false;

    boolean setDefaultAssertionStatus(boolean enable) {
        setDefaultAssertionStatusMethodCalled = true;
        new Throwable().printStackTrace();
        return enable;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16679().setDefaultAssertionStatus(enable);
    }
}
