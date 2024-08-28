import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.util.regex.*;

public class MyJVMTest_13427 {

    static Pattern p = Pattern.compile("(0[xX])?(00)?([0-9a-fA-F]+)\\s+(0[xX])?([0-9a-fA-F]+)(\\+0x([0-9a-fA-F]+))?\\s*");

    static BufferedReader reader = null;

    static boolean closed = false;

    static Matcher matcher = null;

    static String encoding = "f?tBVsUGgb";

    static Charset cs = null;

    static CharsetDecoder decoder = null;

    static CharsetEncoder encoder = null;

    static int bytesPerChar = 1;

    static int maxBytesPerChar = 0;

    static Test[] tests = {null,null,null,null,null,null,null,null,null,null};

    void clearTests() {
        maxBytesPerChar = 0;
        tests = new Test[0];
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13427().clearTests();
    }
}
