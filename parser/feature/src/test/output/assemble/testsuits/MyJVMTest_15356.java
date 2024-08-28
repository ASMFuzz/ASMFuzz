import java.util.*;
import java.util.zip.*;
import java.io.*;
import static java.lang.System.*;
import static java.util.zip.ZipFile.*;

public class MyJVMTest_15356 {

    static byte[] data = { -52, 117, -85, -9, 75, 13, 36, -24, 21, 64 };

    static int offset = 6;

    int u8(byte[] data, int offset) {
        return data[offset] & 0xff;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15356().u8(data, offset));
    }
}
