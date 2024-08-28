import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.util.regex.*;

public class MyJVMTest_12284 {

    static byte[] bb = {97,12,-57,-94,-122,-17,-21,25,-95,-69};

    static Pattern p = Pattern.compile("(0[xX])?(00)?([0-9a-fA-F]+)\\s+(0[xX])?([0-9a-fA-F]+)(\\+0x([0-9a-fA-F]+))?\\s*");

    static BufferedReader reader = null;

    static boolean closed = false;

    static Matcher matcher = null;

    static String encoding = "\\}yo{vMR}S";

    static Charset cs = null;

    static CharsetDecoder decoder = null;

    static CharsetEncoder encoder = null;

    static int bytesPerChar = 4;

    ByteBuffer expand(ByteBuffer bb) {
        ByteBuffer nbb = ByteBuffer.allocate(bb.capacity() * 2);
        bb.flip();
        nbb.put(bb);
        return nbb;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12284().expand(bb));
    }
}
