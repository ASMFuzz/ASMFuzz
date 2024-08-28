import java.io.*;

public class MyJVMTest_14115 {

    static byte[] b = { 65, -9, 90, -18, 9, 60, 28, 26, 101, 118 };

    static int off = 4;

    static int len = 9;

    int read(byte[] b, int off, int len) {
        System.out.println("FileInputStream.read");
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14115().read(b, off, len));
    }
}
