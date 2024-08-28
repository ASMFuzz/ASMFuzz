import java.io.*;

public class MyJVMTest_16716 {

    static String cs = "@+e /\"_\\s5";

    static byte[] array = new byte[20000];

    InputStream go(String cs) throws Exception {
        InputStream is = new ByteArrayInputStream(array);
        Reader r = new InputStreamReader(is, "UTF-16LE");
        r.read();
        return is;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16716().go(cs);
    }
}
