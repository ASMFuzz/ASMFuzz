import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.util.regex.*;

public class MyJVMTest_8351 {

    static String line = ":?jdY\\w>9-";

    static Pattern p = Pattern.compile("(0[xX])?(00)?([0-9a-fA-F]+)\\s+(0[xX])?([0-9a-fA-F]+)(\\+0x([0-9a-fA-F]+))?\\s*");

    static boolean isStateful = false;

    static BufferedReader reader = null;

    static boolean closed = false;

    static Matcher matcher = null;

    boolean isDirective(String line) {
        if (line.startsWith("#STATEFUL")) {
            return isStateful = true;
        }
        return line.startsWith("#");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8351().isDirective(line));
    }
}
