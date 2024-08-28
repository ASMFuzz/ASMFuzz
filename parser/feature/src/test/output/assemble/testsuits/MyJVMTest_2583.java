import java.io.*;

public class MyJVMTest_2583 {

    static byte[] b = { 24, 58, 44, 51, -51, -76, 108, -48, 20, 109 };

    static int off = 915648973;

    static int len = 9;

    static boolean breakIt = false;

    static byte[] buffer = { (byte) 'a', (byte) 'b', (byte) 'c', (byte) 'd', (byte) 'e', (byte) 'f', (byte) 'g' };

    int read(byte[] b, int off, int len) throws IOException {
        if (breakIt)
            throw new IOException("BREAK");
        if (len > buffer.length)
            len = buffer.length;
        System.arraycopy(buffer, 0, b, off, len);
        return len;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2583().read(b, off, len));
    }
}
