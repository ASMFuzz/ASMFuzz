public class MyJVMTest_10237 {

    static int[] a0 = { 0, 3, 0, 0, 5, 0, -1901028394, 1459472526, -1035494484, 0 };

    static int[] a1 = { -1884957058, 9, -1638321389, 0, 0, 8, 2, 5, 3, 6 };

    static int BIT_MASK = 0xEC80F731;

    int[] test_orc(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] | BIT_MASK);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10237().test_orc(a0, a1);
    }
}
