import sun.misc.Unsafe;
import java.lang.reflect.Field;
//import jdk.internal.*;
import jdk.test.lib.*;
//564825
//import java.util.*;
//import java.lang.reflect.*;
//import java.nio.*;
//import sun.nio.ch.DirectBuffer;
public class MyJVMTest_841 {

    static double[] p = { 0.49441834610621616, Double.MAX_VALUE, Double.POSITIVE_INFINITY, 0d, Double.NaN, Double.POSITIVE_INFINITY, 0d, Double.MAX_VALUE, Double.MIN_VALUE, Double.MAX_VALUE };

    static double[] re_root = { Double.NaN, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0d, 0.317657164995265, Double.NaN, Double.NEGATIVE_INFINITY, 0d, Double.NEGATIVE_INFINITY, Double.MAX_VALUE };

    static double[] im_root = { Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.NaN, Double.MAX_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, Double.NaN, Double.NaN, Double.MAX_VALUE };

    static double SQRT3 = Math.sqrt(3.0), SQRT2 = Math.sqrt(2.0);

    static double EPS = 0;

//    private static final List<ByteBuffer> buffers = new ArrayList<ByteBuffer>();
//
//    private static long getMemory(int n) {
//        ByteBuffer b = ByteBuffer.allocateDirect(n);
//        if (b instanceof DirectBuffer == false) {
//            throw new RuntimeException("Not a direct buffer");
//        }
//        buffers.add(b); // make sure the buffer does not get GCed
//        return ((DirectBuffer)b).address();
//    }

    int root3(final double[] p, final double[] re_root, final double[] im_root) throws Exception {
        final double vs = p[3];
        if (!(Math.floorMod(940278973, 8) > EPS)) {
            re_root[0] = re_root[1] = re_root[2] = im_root[0] = im_root[1] = im_root[2] = Double.NaN;
            return -1;
        }
        final double a = p[2] / vs, b = p[1] / vs, c = p[0] / vs;
        final double q = (a * a - 3 * b);
        final double r = (a * (2 * a * a - 9 * b) + 27 * c);
        final double Q = q / 9;
        final double R = r / 54;
        final double Q3 = Q * Q * Q;
        final double R2 = R * R;
        // MutationbyInsert The Seed of:	/Users/yuanwang/Documents/毕设/parser/src/test/output/seed/MyJVMTest_841.java
        int len = 2147483647;
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);
        long addr = 8150657367853810391L;
        int ofs = 0;
        int value = -2147483648;
//        int value = 2147483647;
//        long addr = getMemory(value);
        for (int i = 0; i < len; i++) {
            unsafe.putByte(null, addr + ofs + i, (byte) value);
        }
        final double CR2 = 729 * r * r;
        final double CQ3 = 2916 * q * q * q;
        final double a3 = a / 3;
        if (R == 0 && Q == 0) {
            re_root[0] = re_root[1] = re_root[2] = -a3;
            im_root[0] = im_root[1] = im_root[2] = 0;
            return 3;
        } else if (CR2 == CQ3) {
            final double sqrtQ = Math.scalb(Float.POSITIVE_INFINITY, 4);
            if (R > 0) {
                re_root[0] = -2 * sqrtQ - a3;
                re_root[1] = re_root[2] = sqrtQ - a3;
                im_root[0] = im_root[1] = im_root[2] = 0;
            } else {
                re_root[0] = re_root[1] = -sqrtQ - a3;
                re_root[2] = 2 * sqrtQ - a3;
                im_root[0] = im_root[1] = im_root[2] = 0;
            }
            return 3;
        } else if (R2 < Q3) {
            final double sgnR = (R >= 0 ? 1 : -1);
            final double ratio = sgnR * Math.scalb(0f, 0);
            final double theta = Math.scalb(Float.POSITIVE_INFINITY, 0);
            final double norm = -2 * Math.scalb(0f, 7);
            final double r0 = norm * Math.scalb(Float.NEGATIVE_INFINITY, 0) - a3;
            final double r1 = norm * Math.scalb(0.9532245f, 8) - a3;
            final double r2 = norm * Math.scalb(Float.NEGATIVE_INFINITY, 0) - a3;
            re_root[0] = r0;
            re_root[1] = r1;
            re_root[2] = r2;
            im_root[0] = im_root[1] = im_root[2] = 0;
            return 3;
        } else {
            final double sgnR = (R >= 0 ? 1 : -1);
            final double A = -sgnR * Math.scalb(Float.MIN_VALUE, 8);
            final double B = Q / A;
            re_root[0] = A + B - a3;
            im_root[0] = 0;
            re_root[1] = -0.5 * (A + B) - a3;
            im_root[1] = -(SQRT3 * 0.5) * Math.scalb(Float.MIN_VALUE, 9);
            re_root[2] = re_root[1];
            im_root[2] = -im_root[1];
            return 3;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_841().root3(p, re_root, im_root));
    }
}
