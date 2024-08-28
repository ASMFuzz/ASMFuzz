public class MyJVMTest_2545 {

    static byte[] a = { 104, -117, 35, -76, 10, 109, 25, -7, 110, 125 };

    static byte[] b = { 36, 96, 74, 80, -26, -38, -92, -105, -41, -76 };

    static int[] c = { -1102977863, -838627798, -900058674, 0, 6, -1001785298, 153036833, 1, 0, 9 };

    static int[] d = { 8, 0, 0, 6, 0, 1368038186, 0, 354174110, 9, 0 };

    static int ALIGN_OFF = 8;

    byte[] test_cp_alndst(byte[] a, byte[] b, int[] c, int[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2545().test_cp_alndst(a, b, c, d);
    }
}
