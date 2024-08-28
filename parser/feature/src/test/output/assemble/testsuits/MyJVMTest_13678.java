public class MyJVMTest_13678 {

    static boolean setDefaultAssertionStatusMethodCalled = false;

    static boolean setPackageAssertionStatusMethodCalled = false;

    static boolean setClassAssertionStatusMethodCalled = true;

    boolean isAssertionStatusPublicMethodCalled() {
        return (setDefaultAssertionStatusMethodCalled || setPackageAssertionStatusMethodCalled || setClassAssertionStatusMethodCalled);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13678().isAssertionStatusPublicMethodCalled());
    }
}
