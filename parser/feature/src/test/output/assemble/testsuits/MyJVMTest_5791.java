public class MyJVMTest_5791 {

    static int[] a = { -1631589765, 0, 4, 4, 0, 5, 8, 7, 5, 0 };

    static int b = -309027463;

    static int OFFSET = 3;

    int[] test_vi_off(int[] a, int b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5791().test_vi_off(a, b);
    }
}
