import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.util.regex.*;

public class MyJVMTest_11674 {

    static int n = 0;

    static Pattern p = Pattern.compile("(0[xX])?(00)?([0-9a-fA-F]+)\\s+(0[xX])?([0-9a-fA-F]+)(\\+0x([0-9a-fA-F]+))?\\s*");

    static BufferedReader reader = null;

    static boolean closed = true;

    static Matcher matcher = null;

    static String encoding = "]X,#Ds?CmI";

    static Charset cs = null;

    static CharsetDecoder decoder = null;

    static CharsetEncoder encoder = null;

    static int bytesPerChar = 5;

    String plural(int n) {
        return (n == 1 ? "" : "s");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11674().plural(n));
    }
}
