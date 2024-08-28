public class MyJVMTest_7799 {

    static long[] a = { 4551469854422101394L, 0, 9223372036854775807L, 7200457716365067173L, 7443267866490311955L, 0, 0, 9223372036854775807L, -6446251227722498225L, -6251176348322922953L };

    static long b = -8489885236817057785L;

    static int k = 8;

    int test_vi_inv(long[] a, long b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7799().test_vi_inv(a, b, k);
    }
}
