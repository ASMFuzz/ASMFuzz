public class MyJVMTest_4307 {

    static boolean setDefaultAssertionStatusMethodCalled = true;

    static boolean setPackageAssertionStatusMethodCalled = true;

    static boolean setClassAssertionStatusMethodCalled = true;

    boolean isAssertionStatusPublicMethodCalled() {
        return (setDefaultAssertionStatusMethodCalled || setPackageAssertionStatusMethodCalled || setClassAssertionStatusMethodCalled);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4307().isAssertionStatusPublicMethodCalled());
    }
}
