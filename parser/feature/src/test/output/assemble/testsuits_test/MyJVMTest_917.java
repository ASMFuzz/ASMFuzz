public class MyJVMTest_917 {

    static String msg = "7sb<9nt7lc";

    String fail(String msg) {
        System.err.println(msg);
        java.lang.System.exit(1);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_917().fail(msg);
    }
}
