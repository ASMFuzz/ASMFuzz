import java.io.*;

public class MyJVMTest_12301 {

    static String fParam1Param1 = "B+/q|*nx)*";

    static String fParam1Param2 = "/R+49wO^.&";

    static File fParam1 = new File(fParam1Param1, fParam1Param2);

    static String fParam2 = "[9\"Wf;06Xc";

    static File f = new File(fParam1, fParam2);

    static int len = 8;

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
        new MyJVMTest_12301().test(f, len);
    }
}
