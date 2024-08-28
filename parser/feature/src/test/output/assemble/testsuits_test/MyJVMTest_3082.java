import java.text.Bidi;

public class MyJVMTest_3082 {

    static String string = ":U(U3@-mRG";

    static boolean requiresBidi = true;

    boolean testRequiresBidi(String string, boolean requiresBidi) {
        char[] text = string.toCharArray();
        if (Bidi.requiresBidi(text, 0, text.length) != requiresBidi) {
            throw new RuntimeException("testRequiresBidi failed with '" + string + "', " + requiresBidi);
        }
        return requiresBidi;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3082().testRequiresBidi(string, requiresBidi);
    }
}
