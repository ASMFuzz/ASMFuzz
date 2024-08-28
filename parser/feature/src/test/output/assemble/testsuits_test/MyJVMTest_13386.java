import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.util.regex.*;

public class MyJVMTest_13386 {

    static String line = "^n{gt$q&H6";

    static Pattern p = Pattern.compile("(0[xX])?(00)?([0-9a-fA-F]+)\\s+(0[xX])?([0-9a-fA-F]+)(\\+0x([0-9a-fA-F]+))?\\s*");

    static boolean isStateful = false;

    static BufferedReader reader = null;

    static boolean closed = true;

    static Matcher matcher = null;

    static String encoding = "et7;9\"QK7T";

    static Charset cs = null;

    static CharsetDecoder decoder = null;

    static CharsetEncoder encoder = null;

    static int bytesPerChar = -1654513428;

    boolean isDirective(String line) {
        if (line.startsWith("#STATEFUL")) {
            return isStateful = true;
        }
        return line.startsWith("#");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13386().isDirective(line));
    }
}
