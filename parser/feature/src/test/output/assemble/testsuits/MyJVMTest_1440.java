import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_1440 {

    static byte[] bytes = { -33, 78, 117, 68, 68, -106, -17, -51, 18, -88 };

    void validate(byte[] buf, int offset, int len) throws Exception {
        for (int i = 0; i < len; i++) {
            if (buf[i] != data[offset + i]) {
                throw new Exception("mismatch at " + (offset + i));
            }
        }
    }

    static byte[] data = {116,46,-83,-28,-80,-64,-4,-83,105,-126};

    static int deflatedLength = 1450540032;

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
        new MyJVMTest_1440().InflateData(bytes);
    }
}
