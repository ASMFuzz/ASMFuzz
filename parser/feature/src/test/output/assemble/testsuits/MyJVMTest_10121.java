import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_10121 {

    static byte[] buf = { -31, 126, 57, -60, 95, 99, -2, -22, 114, -33 };

    static int offset = 2;

    static int len = 6;

    static byte[] data = {53,47,30,2,34,80,-29,86,19,48};

    static int deflatedLength = 9;

    int validate(byte[] buf, int offset, int len) throws Exception {
        for (int i = 0; i < len; i++) {
            if (buf[i] != data[offset + i]) {
                throw new Exception("mismatch at " + (offset + i));
            }
        }
        return offset;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10121().validate(buf, offset, len);
    }
}
