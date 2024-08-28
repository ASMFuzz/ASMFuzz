import java.text.Bidi;

public class MyJVMTest_12393 {

    static String string = "dE'3i1mYs|";

    static boolean requiresBidi = true;

    boolean testRequiresBidi(String string, boolean requiresBidi) {
        char[] text = string.toCharArray();
        if (Bidi.requiresBidi(text, 0, text.length) != requiresBidi) {
            throw new RuntimeException("testRequiresBidi failed with '" + string + "', " + requiresBidi);
        }
        return requiresBidi;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12393().testRequiresBidi(string, requiresBidi);
    }
}
