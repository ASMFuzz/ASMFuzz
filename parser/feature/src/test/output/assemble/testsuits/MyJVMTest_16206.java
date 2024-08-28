import java.io.*;
import java.util.Arrays;

public class MyJVMTest_16206 {

    static byte[] streamParam1 = { 103, -80, 9, -21, 119, 88, -121, -96, -12, -110 };

    static InputStream stream = new ByteArrayInputStream(streamParam1);

    static String fName = "ou/OiaW@n`";

    static byte[] fBuffer = {126,107,-3,-39,-114,31,-102,94,100,-127};

    byte[] loadBufferFromStream(InputStream stream) throws IOException {
        int bufferLimit = 200 * 1024;
        byte[] readBuffer = new byte[bufferLimit];
        int actualSize = stream.read(readBuffer);
        if (actualSize >= bufferLimit) {
            throw new IOException("too big for buffer");
        }
        byte[] resultBuffer = new byte[actualSize];
        System.arraycopy(readBuffer, 0, resultBuffer, 0, actualSize);
        return resultBuffer;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_16206().loadBufferFromStream(stream)));
    }
}
