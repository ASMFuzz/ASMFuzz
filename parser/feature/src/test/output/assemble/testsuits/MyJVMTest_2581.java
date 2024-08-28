public class MyJVMTest_2581 {

    static String msg = "g](U0UON4%";

    static T got = null;

    static T expected = null;

    <T> T checkResult(String msg, T got, T expected) {
        if (!expected.equals(got)) {
            String s = String.format("%s: got='%s', expected='%s'", msg, got, expected);
            throw new RuntimeException(s);
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2581().checkResult(msg, got, expected);
    }
}
