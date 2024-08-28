import com.sun.net.httpserver.*;
import java.util.*;
import java.util.concurrent.*;
import java.io.*;
import java.net.*;

public class MyJVMTest_13174 {

    static byte[] isParam1 = { 63, -62, -55, -54, 32, -90, 111, 101, 59, 8 };

    static int isParam2 = 433;

    static int isParam3 = 542;

    static InputStream is = new ByteArrayInputStream(isParam1, isParam2, isParam3);

    static String expected = "iSB+F@SJ_!";

    boolean readAndCheck(InputStream is, String expected) throws IOException {
        int c;
        int count = 0;
        int expLen = expected.length();
        expected = expected.toLowerCase();
        while ((c = is.read()) != -1) {
            c = Character.toLowerCase(c);
            if (c == expected.charAt(count)) {
                count++;
                if (count == expLen) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13174().readAndCheck(is, expected));
    }
}
