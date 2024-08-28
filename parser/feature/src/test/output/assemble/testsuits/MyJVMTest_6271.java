import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_6271 {

    static byte[] isParam1 = { -81, -36, -4, -25, -76, -2, -86, 118, 107, -100 };

    static int isParam2 = 523;

    static int isParam3 = 166;

    static InputStream is = new ByteArrayInputStream(isParam1, isParam2, isParam3);

    String readInputStream(InputStream is) throws IOException {
        byte[] buffer = new byte[4096];
        int len = 0;
        StringBuilder sb = new StringBuilder();
        try (InputStreamReader isr = new InputStreamReader(is)) {
            while ((len = is.read(buffer)) > 0) {
                sb.append(new String(buffer, 0, len));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6271().readInputStream(is));
    }
}
