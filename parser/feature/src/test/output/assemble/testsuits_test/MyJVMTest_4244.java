public class MyJVMTest_4244 {

    static int[] a = { 0, 9, 9, 6, 0, 4, 0, 2, 9, 0 };

    static int b = 0;

    static int SCALE = 2;

    int[] test_vi_scl(int[] a, int b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4244().test_vi_scl(a, b);
    }
}
