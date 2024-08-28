import java.io.*;
import java.util.jar.*;
import java.util.zip.*;
import java.util.Arrays;

public class MyJVMTest_2977 {

    static int descriptor = 2;

    static byte[] data = { 27, 79, 23, -33, 100, -25, 78, 78, 9, 10 };

    int get16(byte[] b, int off) {
        return (b[off] & 0xff) | ((b[off + 1] & 0xff) << 8);
    }

    static ByteArrayOutputStream baos = null;

    static ZipOutputStream zos = null;

    byte[] getField(int descriptor, byte[] data) {
        byte[] rc = null;
        try {
            int i = 0;
            while (i < data.length) {
                if (get16(data, i) == descriptor) {
                    int length = get16(data, i + 2);
                    rc = new byte[length];
                    for (int j = 0; j < length; j++) {
                        rc[j] = data[i + 4 + j];
                    }
                    return rc;
                }
                i += get16(data, i + 2) + 4;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        return rc;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_2977().getField(descriptor, data)));
    }
}
