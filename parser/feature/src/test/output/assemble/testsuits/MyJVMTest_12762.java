import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.util.regex.*;

public class MyJVMTest_12762 {

    static int mode = -797385860;

    static String testRootDir = System.getProperty("test.src", ".");

    static String[] extension = new String[] { ".b2c", ".c2b-irreversible", ".b2c-irreversible" };

    static Pattern p = Pattern.compile("(0[xX])?(00)?([0-9a-fA-F]+)\\s+(0[xX])?([0-9a-fA-F]+)(\\+0x([0-9a-fA-F]+))?\\s*");

    static BufferedReader reader = null;

    static boolean closed = true;

    static Matcher matcher = null;

    static String encoding = "JIDrYg{u&r";

    static Charset cs = null;

    static CharsetDecoder decoder = null;

    static CharsetEncoder encoder = null;

    static int bytesPerChar = -2100018520;

    File testFile(String encoding, int mode) {
        File f = new File(testRootDir, encoding + extension[mode]);
        if (!f.exists())
            return null;
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12762().testFile(encoding, mode));
    }
}
