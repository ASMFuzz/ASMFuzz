public class MyJVMTest_10345 {

    static String cname = "]}5C>kAS|\"";

    static boolean enable = true;

    static boolean setClassAssertionStatusMethodCalled = false;

    String setClassAssertionStatus(String cname, boolean enable) {
        setClassAssertionStatusMethodCalled = true;
        new Throwable().printStackTrace();
        return cname;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10345().setClassAssertionStatus(cname, enable);
    }
}
