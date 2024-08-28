import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.util.regex.*;
import java.util.Arrays;

public class MyJVMTest_1128 {

    static String s = "duEB~nz$s ";

    static Pattern p = Pattern.compile("(0[xX])?(00)?([0-9a-fA-F]+)\\s+(0[xX])?([0-9a-fA-F]+)(\\+0x([0-9a-fA-F]+))?\\s*");

    static BufferedReader reader = null;

    static boolean closed = true;

    static Matcher matcher = null;

    static String encoding = "i=(U8yi(@o";

    static Charset cs = null;

    static CharsetDecoder decoder = null;

    static CharsetEncoder encoder = null;

    static int bytesPerChar = 4;

    byte[] parseBytes(String s) {
        int nb = s.length() / 2;
        byte[] bs = new byte[nb];
        for (int i = 0; i < nb; i++) {
            int j = i * 2;
            if (j + 2 > s.length())
                throw new RuntimeException("Malformed byte string: " + s);
            bs[i] = (byte) Integer.parseInt(s.substring(j, j + 2), 16);
        }
        return bs;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_1128().parseBytes(s)));
    }
}
