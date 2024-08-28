public class MyJVMTest_14668 {

    static String pname = "`2|mx+r|KV";

    static boolean enable = true;

    static boolean setPackageAssertionStatusMethodCalled = false;

    boolean setPackageAssertionStatus(String pname, boolean enable) {
        setPackageAssertionStatusMethodCalled = true;
        new Throwable().printStackTrace();
        return enable;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14668().setPackageAssertionStatus(pname, enable);
    }
}
