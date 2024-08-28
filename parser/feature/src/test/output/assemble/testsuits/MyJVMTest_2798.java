public class MyJVMTest_2798 {

    static long[] a = { 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 0, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 0, -7037542500579624937L, 5371668767279991570L };

    static long[] b = { 0, -9223372036854775808L, 6543349375231847068L, 5755743902770678325L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 0, 9223372036854775807L, 0 };

    static long[] c = { 9223372036854775807L, 9223372036854775807L, 0, -2176139673911130462L, 9223372036854775807L, -6498433033156166030L, 9223372036854775807L, 0, 3760506156377367056L, 0 };

    static long[] d = { 0, 9223372036854775807L, 1383047756142956387L, 597061991299892018L, 9223372036854775807L, 9223372036854775807L, -1037834321764384421L, -8094813093254803527L, -9223372036854775808L, 9223372036854775807L };

    long andReductionImplement(long[] a, long[] b, long[] c, long[] d) {
        long total = -1;
        for (int i = 0; i < a.length; i++) {
            d[i] = (a[i] * b[i]) + (a[i] * c[i]) + (b[i] * c[i]);
            total &= d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2798().andReductionImplement(a, b, c, d));
    }
}
