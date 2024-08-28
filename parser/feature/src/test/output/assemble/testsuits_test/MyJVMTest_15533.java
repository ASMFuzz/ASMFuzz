import java.util.*;
import java.util.zip.*;
import java.util.jar.*;
import java.io.*;

public class MyJVMTest_15533 {

    static byte[] bytes = { -106, -96, 65, 104, -29, 102, -14, 109, -98, -24 };

    static String name = "wclBr8#BvU";

    static int method = 1996316205;

    static byte[] data = {-32,-115,-97,93,-39,107,105,-76,-122,58};

    static byte[] extra = {27,28,67,-55,37,22,-70,-36,-52,-73};

    static String comment = "4803j2''cQ";

    byte[] toExtra(byte[] bytes) throws Exception {
        if (bytes == null)
            return null;
        byte[] v = new byte[bytes.length + 4];
        v[0] = (byte) 0x47;
        v[1] = (byte) 0xff;
        v[2] = (byte) bytes.length;
        v[3] = (byte) (bytes.length << 8);
        System.arraycopy(bytes, 0, v, 4, bytes.length);
        return v;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_15533().toExtra(bytes)));
    }
}
