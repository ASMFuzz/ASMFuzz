import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_14395 {

    static int osParam1 = 350;

    static OutputStream os = new ByteArrayOutputStream(osParam1);

    static int i = 0;

    static boolean isBig = true;

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
        new MyJVMTest_14395().writeInt(os, i, isBig);
    }
}
