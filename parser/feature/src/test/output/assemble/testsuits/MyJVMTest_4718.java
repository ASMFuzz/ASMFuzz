import java.io.*;

public class MyJVMTest_4718 {

    static byte[] b = { 70, -36, -51, 61, -108, -69, -58, 116, -120, -62 };

    static int off = 0;

    static int len = 7;

    int read(byte[] b, int off, int len) {
        System.out.println("FileInputStream.read");
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4718().read(b, off, len));
    }
}
