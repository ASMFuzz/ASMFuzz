public class MyJVMTest_16859 {

    static int[] a0 = { 1, 6, 0, 2, 3, 7, 7, -504969996, -1133467496, 1133925025 };

    static int[] a1 = { 570532385, 0, -414228067, 0, 8, 2, -1235242432, 8, -192632868, 0 };

    static int VALUE = 15;

    int[] test_srac(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] >> VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16859().test_srac(a0, a1);
    }
}
