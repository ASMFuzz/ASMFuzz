public class MyJVMTest_13600 {

    static String enc = "|orR\\~7,B2";

    static String msg = "6hh_9AR?.>";

    static int e0 = 2;

    static int e1 = 0;

    static int b0 = 4;

    static int b1 = 1808579142;

    int fail(String enc, String msg, int e0, int e1, int b0, int b1) throws Exception {
        throw new Exception(enc + ": " + msg + ": Expected " + Integer.toHexString(e0) + " " + Integer.toHexString(e1) + ", got " + Integer.toHexString(b0) + " " + Integer.toHexString(b1));
        return b1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13600().fail(enc, msg, e0, e1, b0, b1);
    }
}
