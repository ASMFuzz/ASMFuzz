public class MyJVMTest_1796 {

    static String msg = "?f7,+J4Bfb";

    static String got = "SJYv~@*Tpz";

    static String expected = "&eo_\"Im8Gi";

    String checkValue(String msg, String got, String expected) {
        if (!expected.equals(got)) {
            String str = String.format("%s: got '%s', expected '%s'", msg, got, expected);
            throw new RuntimeException(str);
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1796().checkValue(msg, got, expected);
    }
}
