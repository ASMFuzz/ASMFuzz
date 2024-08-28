public class MyJVMTest_259 {

    static byte[] a = { -34, -7, 37, 72, 1, 42, 80, 93, -31, 60 };

    static long[] b = { 1274943815173711729L, 7322147834401124037L, 0, 0, 9223372036854775807L, 0, 9223372036854775807L, 0, 0, 0 };

    static byte c = 105;

    static long d = -8289847296311341271L;

    byte[] test_vi_oppos(byte[] a, long[] b, byte c, long d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_259().test_vi_oppos(a, b, c, d);
    }
}
