import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_4988 {

    static OutputStream os = new ByteArrayOutputStream();

    static int i = 0;

    static boolean isBig = false;

    int writeInt(OutputStream os, int i, boolean isBig) throws Exception {
        if (isBig) {
            os.write((i >> 24) & 0xff);
            os.write((i >> 16) & 0xff);
            os.write((i >> 8) & 0xff);
            os.write(i & 0xff);
        } else {
            os.write(i & 0xff);
            os.write((i >> 8) & 0xff);
            os.write((i >> 16) & 0xff);
            os.write((i >> 24) & 0xff);
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4988().writeInt(os, i, isBig);
    }
}
