public class MyJVMTest_16495 {

    static int[] a0 = { 590343980, 2, 7, 6, 1, 0, 0, -1445848815, 3, 0 };

    static int[] a1 = { 1038979509, 5, 2, 1, 6, 1547135591, 0, -2043413722, 1, 893053617 };

    static int b = 3;

    int[] test_orv(int[] a0, int[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] | b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16495().test_orv(a0, a1, b);
    }
}
