public class MyJVMTest_11860 {

    static String msg = "vDDE7TEk~d";

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
        new MyJVMTest_11860().checkResult(msg, got, expected);
    }
}
