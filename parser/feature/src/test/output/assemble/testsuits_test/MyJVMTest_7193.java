import java.io.*;

public class MyJVMTest_7193 {

    static String cs = "'FP`F7z\\0p";

    static byte[] array = new byte[20000];

    InputStream go(String cs) throws Exception {
        InputStream is = new ByteArrayInputStream(array);
        Reader r = new InputStreamReader(is, "UTF-16LE");
        r.read();
        return is;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7193().go(cs);
    }
}
