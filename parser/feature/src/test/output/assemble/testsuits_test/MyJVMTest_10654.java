import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_10654 {

    static byte[] bytes = { -82, 9, -66, -106, -16, -95, -67, -8, -87, 33 };

    void validate(byte[] buf, int offset, int len) throws Exception {
        for (int i = 0; i < len; i++) {
            if (buf[i] != data[offset + i]) {
                throw new Exception("mismatch at " + (offset + i));
            }
        }
    }

    static byte[] data = {4,116,-99,-85,-10,-55,18,-116,37,54};

    static int deflatedLength = -2047669111;

    Inflater InflateData(byte[] bytes) throws Throwable {
        Inflater inflater = new Inflater();
        inflater.setInput(bytes, 0, bytes.length);
        int len = 1024 * 8;
        int offset = 0;
        while (inflater.getRemaining() > 0) {
            byte[] buf = new byte[len];
            int inflated = inflater.inflate(buf, 0, len);
            validate(buf, offset, inflated);
            offset += inflated;
        }
        return inflater;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10654().InflateData(bytes);
    }
}
