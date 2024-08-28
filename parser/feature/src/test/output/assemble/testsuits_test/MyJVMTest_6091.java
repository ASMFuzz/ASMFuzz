import java.io.*;
import java.util.zip.*;

public class MyJVMTest_6091 {

    static byte[] isParam1 = { 108, 46, -29, -58, 121, -116, -55, -81, -127, -69 };

    static int isParam2 = 555;

    static int isParam3 = 201;

    static InputStream is = new ByteArrayInputStream(isParam1, isParam2, isParam3);

    StringBuilder printStream(InputStream is) throws IOException {
        Reader r = new InputStreamReader(is);
        StringBuilder sb = new StringBuilder();
        char[] buf = new char[1024];
        int n;
        while ((n = r.read(buf)) > 0) {
            sb.append(buf, 0, n);
        }
        System.out.print(sb);
        return sb;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6091().printStream(is);
    }
}
