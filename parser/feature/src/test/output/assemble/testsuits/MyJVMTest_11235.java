public class MyJVMTest_11235 {

    static int[] a = { 4, 316364036, 9, 5, 0, 7, 8, 3, 0, 1995814641 };

    static int SCALE = 2;

    int[] test_ci_scl(int[] a) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11235().test_ci_scl(a);
    }
}
