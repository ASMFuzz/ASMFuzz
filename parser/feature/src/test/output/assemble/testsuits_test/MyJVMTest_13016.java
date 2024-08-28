public class MyJVMTest_13016 {

    static int[] a = { 0, 657847713, -1183775722, 586859632, 0, 0, -1318043038, 0, 7, 6 };

    static long[] b = { 9223372036854775807L, 3804030328117068398L, 0, -3203855569326302008L, 9223372036854775807L, 9223372036854775807L, 0, 9223372036854775807L, 4418382818110818691L, -9223372036854775808L };

    static int c = -2034110600;

    static long d = 0;

    static int ALIGN_OFF = 8;

    int[] test_vi_aln(int[] a, long[] b, int c, long d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13016().test_vi_aln(a, b, c, d);
    }
}
