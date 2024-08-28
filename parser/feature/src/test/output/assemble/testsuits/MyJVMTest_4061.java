import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_4061 {

    static byte[] a = { 112, 66, -99, -63, -46, 46, 94, 24, 46, 7 };

    static int length = 4;

    byte[] trim(byte[] a, int length) {
        byte[] res = new byte[length];
        System.arraycopy(a, 0, res, 0, length);
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_4061().trim(a, length)));
    }
}
