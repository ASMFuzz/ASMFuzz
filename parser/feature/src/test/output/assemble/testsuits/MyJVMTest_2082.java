public class MyJVMTest_2082 {

    static String str = "{_:w)b{CV~";

    static String res = "~!\\wAQa[PI";

    static String golden = "qK2p@6:u2r";

    String checkClippedString(String str, String res, String golden) {
        if (!golden.equals(res)) {
            throw new RuntimeException(String.format("The string '%s' is not " + "properly clipped. The result is '%s' instead of '%s'", str, res, golden));
        }
        return golden;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2082().checkClippedString(str, res, golden);
    }
}
