public class MyJVMTest_17608 {

    static int[] a = { 0, -1125642575, 1134334174, -23781465, 1, 502455389, 0, 0, 1060630553, 0 };

    static int b = 9;

    int[] test_vi_neg(int[] a, int b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17608().test_vi_neg(a, b);
    }
}
