import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_937 {

    static byte[] buf = { -45, -55, 47, -75, -54, 21, -37, -59, -127, -108 };

    static int offset = 3;

    static int len = 2;

    static byte[] data = {20,-94,-78,93,-51,-92,-64,9,-99,-14};

    static int deflatedLength = 1334279420;

    int validate(byte[] buf, int offset, int len) throws Exception {
        for (int i = 0; i < len; i++) {
            if (buf[i] != data[offset + i]) {
                throw new Exception("mismatch at " + (offset + i));
            }
        }
        return offset;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_937().validate(buf, offset, len);
    }
}
