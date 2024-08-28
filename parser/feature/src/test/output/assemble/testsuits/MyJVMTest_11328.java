public class MyJVMTest_11328 {

    static String str = "1uVlfp,\\Q|";

    static String res = "Q]kBb[-~CC";

    static String golden = ">?u\\<:)+l9";

    String checkClippedString(String str, String res, String golden) {
        if (!golden.equals(res)) {
            throw new RuntimeException(String.format("The string '%s' is not " + "properly clipped. The result is '%s' instead of '%s'", str, res, golden));
        }
        return golden;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11328().checkClippedString(str, res, golden);
    }
}
