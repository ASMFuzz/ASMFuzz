public class MyJVMTest_7991 {

    static long[] a = { -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 0, 0, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 6879434923034831669L, -5930952592484518845L };

    static long[] b = { 0, 0, -9223372036854775808L, 0, 9223372036854775807L, 4947840612746553075L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L };

    static long[] c = { -9223372036854775808L, 6613519302720916189L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 2986907446684447499L, 9223372036854775807L, 0, -285743911278063123L, 9223372036854775807L };

    static long[] d = { 0, 9223372036854775807L, 0, 0, 2341813134743424613L, 9223372036854775807L, -6077259296475776394L, -9223372036854775808L, 8431539871673356097L, -7888053488269182718L };

    long orReductionImplement(long[] a, long[] b, long[] c, long[] d) {
        long total = 0;
        for (int i = 0; i < a.length; i++) {
            d[i] = (a[i] * b[i]) + (a[i] * c[i]) + (b[i] * c[i]);
            total |= d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7991().orReductionImplement(a, b, c, d));
    }
}
