import java.io.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_15400 {

    static int defParam1 = 208;

    static boolean defParam2 = true;

    static Deflater def = new Deflater(defParam1, defParam2);

    static byte[] in = { 12, -112, -118, -2, -82, 39, -49, -55, 108, 80 };

    static int len = 0;

    static byte[] out1 = { 30, -107, -78, -22, 109, -100, 102, -109, -13, 30 };

    static byte[] out2 = { -60, 78, 27, -30, 57, -19, 70, -16, 82, 12 };

    static boolean nowrap = false;

    int checkStream(Deflater def, byte[] in, int len, byte[] out1, byte[] out2, boolean nowrap) throws Throwable {
        Arrays.fill(out1, (byte) 0);
        Arrays.fill(out2, (byte) 0);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (DeflaterOutputStream defos = new DeflaterOutputStream(baos, def)) {
            defos.write(in, 0, len);
        }
        out1 = baos.toByteArray();
        int m = out1.length;
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
        new MyJVMTest_15400().checkStream(def, in, len, out1, out2, nowrap);
    }
}
