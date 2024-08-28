public class MyJVMTest_5248 {

    static String pname = "C2wJ4L(F@:";

    static boolean enable = false;

    static boolean setPackageAssertionStatusMethodCalled = false;

    boolean setPackageAssertionStatus(String pname, boolean enable) {
        setPackageAssertionStatusMethodCalled = true;
        new Throwable().printStackTrace();
        return enable;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5248().setPackageAssertionStatus(pname, enable);
    }
}
