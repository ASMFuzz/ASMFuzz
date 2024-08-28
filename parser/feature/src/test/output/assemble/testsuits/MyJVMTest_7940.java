import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.util.regex.*;

public class MyJVMTest_7940 {

    static CharBuffer cb = null;

    static Pattern p = Pattern.compile("(0[xX])?(00)?([0-9a-fA-F]+)\\s+(0[xX])?([0-9a-fA-F]+)(\\+0x([0-9a-fA-F]+))?\\s*");

    static BufferedReader reader = null;

    static boolean closed = true;

    static Matcher matcher = null;

    static String encoding = "{xXUCB#X7$";

    static Charset cs = null;

    static CharsetDecoder decoder = null;

    static CharsetEncoder encoder = null;

    static int bytesPerChar = 1416649592;

    CharBuffer expand(CharBuffer cb) {
        CharBuffer ncb = CharBuffer.allocate(cb.capacity() * 2);
        cb.flip();
        ncb.put(cb);
        return ncb;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7940().expand(cb));
    }
}
