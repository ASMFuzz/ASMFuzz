import com.sun.net.httpserver.*;
import java.util.*;
import java.util.concurrent.*;
import java.io.*;
import java.net.*;

public class MyJVMTest_3832 {

    static byte[] isParam1 = { -92, 109, 30, 72, 54, 23, 59, -89, 88, 66 };

    static InputStream is = new ByteArrayInputStream(isParam1);

    static String expected = ">%`e^Q\\t$T";

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
        System.out.println(new MyJVMTest_3832().readAndCheck(is, expected));
    }
}
