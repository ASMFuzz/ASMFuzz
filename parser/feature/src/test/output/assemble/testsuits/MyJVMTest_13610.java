public class MyJVMTest_13610 {

    static int[] a = { 1, 0, 0, 2, 5, 0, 0, 0, 0, -682859289 };

    static int b = 720340193;

    static int SCALE = 2;

    int[] test_vi_scl(int[] a, int b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13610().test_vi_scl(a, b);
    }
}
