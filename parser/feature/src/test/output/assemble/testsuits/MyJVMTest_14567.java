public class MyJVMTest_14567 {

    static String msg = "K:DhZzNq5A";

    static int i = 0;

    static double d = Double.NEGATIVE_INFINITY;

    static String s = "jK=#Tx.3v:";

    String fail(String msg) throws Exception {
        throw new Exception("FAIL: " + msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14567().fail(msg);
    }
}
