public class MyJVMTest_3019 {

    static int[] a = { 2, 5, 7, -1707206009, 4, 0, 0, -16879389, 2, 7 };

    static int b = 8;

    int[] test_vi(int[] a, int b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3019().test_vi(a, b);
    }
}
