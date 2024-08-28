import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.util.regex.*;

public class MyJVMTest_2979 {

    static byte[] bb = {108,-106,-50,29,-125,115,42,15,75,-26};

    static Pattern p = Pattern.compile("(0[xX])?(00)?([0-9a-fA-F]+)\\s+(0[xX])?([0-9a-fA-F]+)(\\+0x([0-9a-fA-F]+))?\\s*");

    static BufferedReader reader = null;

    static boolean closed = false;

    static Matcher matcher = null;

    static String encoding = "jbDzpe4Ky3";

    static Charset cs = null;

    static CharsetDecoder decoder = null;

    static CharsetEncoder encoder = null;

    static int bytesPerChar = 0;

    ByteBuffer expand(ByteBuffer bb) {
        ByteBuffer nbb = ByteBuffer.allocate(bb.capacity() * 2);
        bb.flip();
        nbb.put(bb);
        return nbb;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2979().expand(bb));
    }
}
