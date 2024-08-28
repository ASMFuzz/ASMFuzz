public class MyJVMTest_39 {

    static long[] a = { -9223372036854775808L, 0, 2249995167329017955L, 9223372036854775807L, 0, 7228055058439106767L, 0, 9223372036854775807L, 0, -9223372036854775808L };

    static long[] b = { -9223372036854775808L, -7017098533375689607L, 0, 3053338017266845125L, -9223372036854775808L, 9223372036854775807L, 0, 0, 8673731218318996986L, 0 };

    static long[] c = { 9223372036854775807L, 9223372036854775807L, -8714642697867268867L, 9223372036854775807L, 0, 0, 0, 0, 0, 1420111100139793993L };

    static long[] d = { -2229651503806864243L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, -1975009100579556410L, 9223372036854775807L, 0, -9223372036854775808L, 5308541000974089263L, 9223372036854775807L };

    long xorReductionImplement(long[] a, long[] b, long[] c, long[] d) {
        long total = -1;
        for (int i = 0; i < a.length; i++) {
            d[i] = (a[i] * b[i]) + (a[i] * c[i]) + (b[i] * c[i]);
            total ^= d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_39().xorReductionImplement(a, b, c, d));
    }
}
