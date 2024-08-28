import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.util.regex.*;

public class MyJVMTest_3432 {

    static int mode = 998642566;

    static String testRootDir = System.getProperty("test.src", ".");

    static String[] extension = new String[] { ".b2c", ".c2b-irreversible", ".b2c-irreversible" };

    static Pattern p = Pattern.compile("(0[xX])?(00)?([0-9a-fA-F]+)\\s+(0[xX])?([0-9a-fA-F]+)(\\+0x([0-9a-fA-F]+))?\\s*");

    static BufferedReader reader = null;

    static boolean closed = true;

    static Matcher matcher = null;

    static String encoding = "2n+':j,gPF";

    static Charset cs = null;

    static CharsetDecoder decoder = null;

    static CharsetEncoder encoder = null;

    static int bytesPerChar = 1323979616;

    File testFile(String encoding, int mode) {
        File f = new File(testRootDir, encoding + extension[mode]);
        if (!f.exists())
            return null;
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3432().testFile(encoding, mode));
    }
}
