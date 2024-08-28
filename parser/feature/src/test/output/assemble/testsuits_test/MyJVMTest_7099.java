import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_7099 {

    static byte[] a = { 61, 87, 29, -27, 69, -34, -46, -48, 0, 91 };

    static int length = 0;

    static String name = "HY-F?Y^}hU";

    static byte[] data = {-120,81,-65,60,1,-104,-35,-5,-111,49};

    static int level = 5;

    static int STRIDE = 1024;

    byte[] trim(byte[] a, int length) {
        byte[] res = new byte[length];
        System.arraycopy(a, 0, res, 0, length);
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_7099().trim(a, length)));
    }
}
