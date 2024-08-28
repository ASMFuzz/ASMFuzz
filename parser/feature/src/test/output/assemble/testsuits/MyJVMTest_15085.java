import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.util.regex.*;

public class MyJVMTest_15085 {

    static CharBuffer cb = null;

    static Pattern p = Pattern.compile("(0[xX])?(00)?([0-9a-fA-F]+)\\s+(0[xX])?([0-9a-fA-F]+)(\\+0x([0-9a-fA-F]+))?\\s*");

    static BufferedReader reader = null;

    static boolean closed = true;

    static Matcher matcher = null;

    static String encoding = "4=!FdKn[xS";

    static Charset cs = null;

    static CharsetDecoder decoder = null;

    static CharsetEncoder encoder = null;

    static int bytesPerChar = 0;

    int getCodePoint(CharBuffer cb) {
        char c = cb.get();
        if (Character.isHighSurrogate(c))
            return Character.toCodePoint(c, cb.get());
        else
            return c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15085().getCodePoint(cb));
    }
}
