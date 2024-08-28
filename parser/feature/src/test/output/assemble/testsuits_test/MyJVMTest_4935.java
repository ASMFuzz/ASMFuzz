import java.io.IOException;

public class MyJVMTest_4935 {

    static byte[] buf = { -109, 33, 68, 67, -33, -83, 55, -29, -104, 79 };

    static int off = 0;

    static int len = 3;

    static int shortFall = 1;

    static byte next = 0;

    int read(byte[] buf, int off, int len) throws IOException {
        int n = len - shortFall;
        for (int i = off; i < n; i++) buf[i] = next++;
        return n;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4935().read(buf, off, len));
    }
}
