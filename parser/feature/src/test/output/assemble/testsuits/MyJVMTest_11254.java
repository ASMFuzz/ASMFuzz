import java.io.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_11254 {

    static int defParam1 = 645;

    static Deflater def = new Deflater(defParam1);

    static byte[] in = { 100, 12, 65, 53, -84, -105, 2, 91, -48, -103 };

    static int len = 1789239509;

    static byte[] out1 = { 64, 98, -89, 11, 52, -96, -109, -89, 100, -82 };

    static byte[] out2 = { 8, 75, 114, -66, -122, -38, -94, 124, 41, -95 };

    static boolean nowrap = true;

    int check(Deflater def, byte[] in, int len, byte[] out1, byte[] out2, boolean nowrap) throws Throwable {
        Arrays.fill(out1, (byte) 0);
        Arrays.fill(out2, (byte) 0);
        def.setInput(in, 0, len);
        def.finish();
        int m = def.deflate(out1);
        Inflater inf = new Inflater(nowrap);
        inf.setInput(out1, 0, m);
        int n = inf.inflate(out2);
        if (n != len || !Arrays.equals(Arrays.copyOf(in, len), Arrays.copyOf(out2, len)) || inf.inflate(out2) != 0) {
            System.out.printf("m=%d, n=%d, len=%d, eq=%b%n", m, n, len, Arrays.equals(in, out2));
            throw new RuntimeException("De/inflater failed:" + def);
        }
        return len;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11254().check(def, in, len, out1, out2, nowrap);
    }
}
