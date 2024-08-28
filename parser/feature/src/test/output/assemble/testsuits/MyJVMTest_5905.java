import java.util.*;
import java.util.zip.*;
import java.io.*;
import static java.lang.System.*;
import static java.util.zip.ZipFile.*;

public class MyJVMTest_5905 {

    static byte[] data = { -4, -8, -104, -40, 111, 70, -8, 127, 42, 88 };

    static int offset = -979070660;

    int u8(byte[] data, int offset) {
        return data[offset] & 0xff;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5905().u8(data, offset));
    }
}
