import java.io.*;

public class MyJVMTest_2995 {

    static String fParam1 = "#R!/M}54C,";

    static File f = new File(fParam1);

    static int len = 3;

    static int MAX_LEN = 1 << 16;

    int test(File f, int len) throws Exception {
        FileOutputStream fo = new FileOutputStream(f);
        for (int i = 0; i < len; i++) fo.write('x');
        fo.close();
        FileInputStream fi = new FileInputStream(f);
        Reader rd = new InputStreamReader(fi, "US-ASCII");
        char[] cb = new char[MAX_LEN + 100];
        int n = rd.read(cb, 0, cb.length);
        System.out.println(len + " : " + n);
        if (len != n)
            throw new Exception("Expected " + len + ", read " + n);
        return len;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2995().test(f, len);
    }
}
