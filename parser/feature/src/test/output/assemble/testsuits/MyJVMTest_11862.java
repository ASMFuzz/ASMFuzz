import java.io.*;

public class MyJVMTest_11862 {

    static byte[] b = { -61, 21, 127, -62, 105, 125, -45, 114, 44, -120 };

    static int off = -1955663929;

    static int len = 0;

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
        System.out.println(new MyJVMTest_11862().read(b, off, len));
    }
}
