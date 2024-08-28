import java.io.*;
import java.util.zip.*;

public class MyJVMTest_15551 {

    static byte[] isParam1 = { -80, -9, 48, -42, 92, 26, 39, 93, -108, -18 };

    static InputStream is = new ByteArrayInputStream(isParam1);

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
        new MyJVMTest_15551().printStream(is);
    }
}
