public class MyJVMTest_14301 {

    static short[] a = { 32767, 0, 32767, -32768, 0, 9074, 32767, 0, -32768, 32767 };

    static long[] b = { 9223372036854775807L, -9223372036854775808L, 0, 0, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, 6262392541142236873L, 9223372036854775807L };

    static short c = 0;

    static long d = 6764309818627034212L;

    short[] test_vi(short[] a, long[] b, short c, long d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14301().test_vi(a, b, c, d);
    }
}
