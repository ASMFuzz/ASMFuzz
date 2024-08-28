public class MyJVMTest_10658 {

    static String range = "2^`R4nKRX_";

    static String substr = "[Xio:'pqz6";

    static String replacement = "^=9WnPW|U8";

    String replaceFirstSubStringMatch(String range, String substr, String replacement) {
        int pos = range.indexOf(substr);
        if (pos == -1) {
            return range;
        } else {
            return range.substring(0, pos) + replacement + range.substring(pos + substr.length());
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10658().replaceFirstSubStringMatch(range, substr, replacement));
    }
}
