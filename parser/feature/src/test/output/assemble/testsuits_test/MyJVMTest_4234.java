public class MyJVMTest_4234 {

    static String enc = "fcQ/kO^&#,";

    static String msg = ".m/s3='V\\l";

    static int e0 = 5;

    static int e1 = 5;

    static int b0 = 6;

    static int b1 = -917048264;

    int fail(String enc, String msg, int e0, int e1, int b0, int b1) throws Exception {
        throw new Exception(enc + ": " + msg + ": Expected " + Integer.toHexString(e0) + " " + Integer.toHexString(e1) + ", got " + Integer.toHexString(b0) + " " + Integer.toHexString(b1));
        return b1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4234().fail(enc, msg, e0, e1, b0, b1);
    }
}
