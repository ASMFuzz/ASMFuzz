public class MyJVMTest_5152 {

    static String msg = "iCEe`Zo$43";

    static int i = 0;

    static double d = Double.NaN;

    static String s = "6}g*]BLWl{";

    String fail(String msg) throws Exception {
        throw new Exception("FAIL: " + msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5152().fail(msg);
    }
}
