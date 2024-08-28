import java.util.*;
import java.util.zip.*;
import java.io.*;
import static java.lang.System.*;
import static java.util.zip.ZipFile.*;

public class MyJVMTest_3995 {

    static byte[] data = { 15, 14, 91, -89, 85, -87, 125, 7, -21, -63 };

    static int offset = 6;

    int u8(byte[] data, int offset) {
        return data[offset] & 0xff;
    }

    int u16(byte[] data, int offset) {
        return u8(data, offset) + (u8(data, offset + 1) << 8);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3995().u16(data, offset));
    }
}
