import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_16618 {

    static byte[] a = { -60, 43, 62, -88, -120, 115, 32, 10, 65, 43 };

    static int length = 2;

    static String name = "gRj\"kXTqe3";

    static byte[] data = {-98,71,-51,-83,113,-99,2,-55,92,-54};

    static int level = 0;

    static int STRIDE = 1024;

    byte[] trim(byte[] a, int length) {
        byte[] res = new byte[length];
        System.arraycopy(a, 0, res, 0, length);
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_16618().trim(a, length)));
    }
}
