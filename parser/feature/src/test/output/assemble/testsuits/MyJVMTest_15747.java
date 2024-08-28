import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_15747 {

    static byte[] isParam1 = { 71, -126, 79, -12, -35, -91, -62, -57, -63, -5 };

    static InputStream is = new ByteArrayInputStream(isParam1);

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
        System.out.println(new MyJVMTest_15747().readInputStream(is));
    }
}
