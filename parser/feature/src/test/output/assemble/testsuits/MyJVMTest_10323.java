import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.util.regex.*;
import java.util.Arrays;

public class MyJVMTest_10323 {

    static String s = "wr&}=UK2=;";

    static Pattern p = Pattern.compile("(0[xX])?(00)?([0-9a-fA-F]+)\\s+(0[xX])?([0-9a-fA-F]+)(\\+0x([0-9a-fA-F]+))?\\s*");

    static BufferedReader reader = null;

    static boolean closed = false;

    static Matcher matcher = null;

    static String encoding = "l}{7LqJ4p2";

    static Charset cs = null;

    static CharsetDecoder decoder = null;

    static CharsetEncoder encoder = null;

    static int bytesPerChar = 9;

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
        System.out.println(Arrays.asList(new MyJVMTest_10323().parseBytes(s)));
    }
}
