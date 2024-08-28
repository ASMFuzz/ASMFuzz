import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_13419 {

    static byte[] a = { -38, 76, 18, 36, 82, 19, -95, -116, 13, -39 };

    static int length = 0;

    byte[] trim(byte[] a, int length) {
        byte[] res = new byte[length];
        System.arraycopy(a, 0, res, 0, length);
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_13419().trim(a, length)));
    }
}
