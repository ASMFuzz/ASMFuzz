import java.util.*;
import java.util.zip.*;
import java.io.*;
import static java.lang.System.*;
import static java.util.zip.ZipFile.*;

public class MyJVMTest_13347 {

    static byte[] data = { -99, 51, -5, -116, -54, 111, -91, -115, 97, 56 };

    static int offset = 0;

    int u8(byte[] data, int offset) {
        return data[offset] & 0xff;
    }

    int u16(byte[] data, int offset) {
        return u8(data, offset) + (u8(data, offset + 1) << 8);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13347().u16(data, offset));
    }
}
