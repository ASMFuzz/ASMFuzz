public class MyJVMTest_17556 {

    static long[] a = { -9223372036854775808L, 2851293171565739590L, 0, 9223372036854775807L, 0, 0, 9223372036854775807L, -9223372036854775808L, 0, -9223372036854775808L };

    static long[] b = { -4336473855592017084L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L, 0, 0, 0 };

    static long[] c = { -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 0, -519277576299469820L, 9223372036854775807L, 0, -4373357055672284341L, -3749018940088347417L, -6425868460250629754L };

    static long[] d = { 9223372036854775807L, -9223372036854775808L, 0, 9223372036854775807L, 9223372036854775807L, 0, -9223372036854775808L, 9223372036854775807L, 0, -5180877579478194719L };

    long orReductionImplement(long[] a, long[] b, long[] c, long[] d) {
        long total = 0;
        for (int i = 0; i < a.length; i++) {
            d[i] = (a[i] * b[i]) + (a[i] * c[i]) + (b[i] * c[i]);
            total |= d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17556().orReductionImplement(a, b, c, d));
    }
}
