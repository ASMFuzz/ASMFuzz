import java.io.IOException;

public class MyJVMTest_14339 {

    static byte[] buf = { 43, 71, -45, 7, 100, 12, -39, -108, 90, -24 };

    static int off = 8;

    static int len = 4;

    static int shortFall = -1151398476;

    static byte next = 0;

    int read(byte[] buf, int off, int len) throws IOException {
        int n = len - shortFall;
        for (int i = off; i < n; i++) buf[i] = next++;
        return n;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14339().read(buf, off, len));
    }
}
