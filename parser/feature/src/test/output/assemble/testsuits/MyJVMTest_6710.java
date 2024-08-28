import java.io.*;
import java.util.Arrays;

public class MyJVMTest_6710 {

    static byte[] streamParam1 = { 32, -124, 20, -94, -44, 67, 125, 118, -25, 100 };

    static InputStream stream = new ByteArrayInputStream(streamParam1);

    static String fName = "]j8yicFQ}&";

    static byte[] fBuffer = {57,-124,-65,75,97,94,-117,-128,86,-101};

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
        System.out.println(Arrays.asList(new MyJVMTest_6710().loadBufferFromStream(stream)));
    }
}
