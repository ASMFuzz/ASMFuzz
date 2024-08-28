public class MyJVMTest_9178 {

    static long[] a = { -552397687659194175L, 0, 0, -9223372036854775808L, -9223372036854775808L, 0, -9223372036854775808L, 0, 2744423108274460952L, 0 };

    static long[] b = { -9223372036854775808L, 9223372036854775807L, 0, 8517798974823037245L, 2171058915551812104L, 0, 9223372036854775807L, 9223372036854775807L, 1218208503803457683L, 0 };

    static long[] c = { 7171287793376613496L, -9223372036854775808L, -9223372036854775808L, 0, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, 0, 0, 1150890760230893772L };

    static long[] d = { 0, 0, 7003062690870288657L, 8713434932935244360L, 9223372036854775807L, -9223372036854775808L, 0, 9223372036854775807L, -9223372036854775808L, 0 };

    long xorReductionImplement(long[] a, long[] b, long[] c, long[] d) {
        long total = -1;
        for (int i = 0; i < a.length; i++) {
            d[i] = (a[i] * b[i]) + (a[i] * c[i]) + (b[i] * c[i]);
            total ^= d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9178().xorReductionImplement(a, b, c, d));
    }
}
