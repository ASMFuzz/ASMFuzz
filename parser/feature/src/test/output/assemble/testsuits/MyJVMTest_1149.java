public class MyJVMTest_1149 {

    static String cname = "q3om^y(hNi";

    static boolean enable = true;

    static boolean setClassAssertionStatusMethodCalled = false;

    String setClassAssertionStatus(String cname, boolean enable) {
        setClassAssertionStatusMethodCalled = true;
        new Throwable().printStackTrace();
        return cname;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1149().setClassAssertionStatus(cname, enable);
    }
}
