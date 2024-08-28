public class MyJVMTest_303 {

    static int[] a0 = { -770776447, 7, 0, 0, 0, -3385453, 1, 8, 1863220784, -56918486 };

    static int[] a1 = { 0, 2, 0, 799318178, 0, -801803131, 0, 0, 1, 0 };

    static int SHIFT = 32;

    int[] test_srac_on(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] >> (-SHIFT));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_303().test_srac_on(a0, a1);
    }
}
