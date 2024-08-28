import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.util.regex.*;

public class MyJVMTest_4033 {

    static String line = "!)7WQM%hh!";

    static Pattern p = Pattern.compile("(0[xX])?(00)?([0-9a-fA-F]+)\\s+(0[xX])?([0-9a-fA-F]+)(\\+0x([0-9a-fA-F]+))?\\s*");

    static boolean isStateful = false;

    static BufferedReader reader = null;

    static boolean closed = false;

    static Matcher matcher = null;

    static String encoding = "]#DYD(va^<";

    static Charset cs = null;

    static CharsetDecoder decoder = null;

    static CharsetEncoder encoder = null;

    static int bytesPerChar = 1;

    boolean isDirective(String line) {
        if (line.startsWith("#STATEFUL")) {
            return isStateful = true;
        }
        return line.startsWith("#");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4033().isDirective(line));
    }
}
