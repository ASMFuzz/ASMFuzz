public class MyJVMTest_3482 {

    static int[] a = { 3, 0, 0, 0, 664730961, -984713939, 0, 7, 0, -517662685 };

    static int[] b = { 870757449, 1, 2093295230, 5, 653869915, 167734286, 9, 1, 0, 2019506993 };

    static int c = 0;

    static int d = 0;

    static int SCALE = 2;

    int[] test_2vi_scl(int[] a, int[] b, int c, int d) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = c;
            b[i * SCALE] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3482().test_2vi_scl(a, b, c, d);
    }
}
