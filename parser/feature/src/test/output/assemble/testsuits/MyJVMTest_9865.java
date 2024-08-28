import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.util.regex.*;

public class MyJVMTest_9865 {

    static byte[] bs = { 116, 16, 97, -111, 127, 88, -98, -57, -64, 28 };

    static Pattern p = Pattern.compile("(0[xX])?(00)?([0-9a-fA-F]+)\\s+(0[xX])?([0-9a-fA-F]+)(\\+0x([0-9a-fA-F]+))?\\s*");

    static BufferedReader reader = null;

    static boolean closed = true;

    static Matcher matcher = null;

    static String encoding = "m>u7<C*='/";

    static Charset cs = null;

    static CharsetDecoder decoder = null;

    static CharsetEncoder encoder = null;

    static int bytesPerChar = 5;

    String printBytes(byte[] bs) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bs.length; i++) {
            sb.append(Integer.toHexString((bs[i] >> 4) & 0xf));
            sb.append(Integer.toHexString((bs[i] >> 0) & 0xf));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9865().printBytes(bs));
    }
}
