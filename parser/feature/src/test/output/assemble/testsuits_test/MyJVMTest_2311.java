public class MyJVMTest_2311 {

    static short[] a = { 32767, 17934, -17476, 0, 0, 0, 0, 0, 0, 0 };

    static long[] b = { -5923471519190489512L, 7364217582100197637L, -4308636554092996335L, 9223372036854775807L, 0, 0, -3628624637200218502L, -9223372036854775808L, 0, 0 };

    static short c = 0;

    static long d = 9223372036854775807L;

    short[] test_vi_oppos(short[] a, long[] b, short c, long d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2311().test_vi_oppos(a, b, c, d);
    }
}
