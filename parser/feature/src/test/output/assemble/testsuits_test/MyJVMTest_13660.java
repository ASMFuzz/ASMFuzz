import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.util.regex.*;

public class MyJVMTest_13660 {

    static int cp = 2;

    static Pattern p = Pattern.compile("(0[xX])?(00)?([0-9a-fA-F]+)\\s+(0[xX])?([0-9a-fA-F]+)(\\+0x([0-9a-fA-F]+))?\\s*");

    static BufferedReader reader = null;

    static boolean closed = false;

    static Matcher matcher = null;

    static String encoding = ",d!Th{&cXP";

    static Charset cs = null;

    static CharsetDecoder decoder = null;

    static CharsetEncoder encoder = null;

    static int bytesPerChar = 1915127128;

    String printCodePoint(int cp) {
        StringBuffer sb = new StringBuffer();
        sb.append("U+");
        if (cp > 0xffff)
            sb.append(Integer.toHexString((cp >> 16) & 0xf));
        sb.append(Integer.toHexString((cp >> 12) & 0xf));
        sb.append(Integer.toHexString((cp >> 8) & 0xf));
        sb.append(Integer.toHexString((cp >> 4) & 0xf));
        sb.append(Integer.toHexString((cp >> 0) & 0xf));
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13660().printCodePoint(cp));
    }
}
