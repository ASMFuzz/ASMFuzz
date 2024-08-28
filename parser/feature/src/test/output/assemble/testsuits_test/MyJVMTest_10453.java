import java.text.*;
import java.util.*;

public class MyJVMTest_10453 {

    static BreakIterator bi = null;

    static String type = "%G>USR4#z1";

    static String expected = ")Km~qQ#<3f";

    static String description = "c>7r7Oa!W;";

    String toString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append("  0x" + Integer.toHexString(s.charAt(i)));
        }
        return sb.toString();
    }

    static String[][] source = { { "\ufa30\ufa31 \ufa69\ufa6a", "JIS X 0213 compatibility additions (\\uFA30-\\uFA6A)" } };

    static boolean err = false;

    StringBuilder testBreakIterator(BreakIterator bi, String type, String source, String expected, String description) {
        bi.setText(source);
        int start = bi.first();
        int end = bi.next();
        StringBuilder sb = new StringBuilder();
        for (; end != BreakIterator.DONE; start = end, end = bi.next()) {
            sb.append(source.substring(start, end));
            sb.append('/');
        }
        if (!expected.equals(sb.toString())) {
            System.err.println("Failed: Incorrect " + type + "-breaking for " + description + "\n\tExpected: " + toString(expected) + "\n\tGot:      " + toString(sb.toString()));
            err = true;
        }
        return sb;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10453().testBreakIterator(bi, type, source, expected, description);
    }
}
