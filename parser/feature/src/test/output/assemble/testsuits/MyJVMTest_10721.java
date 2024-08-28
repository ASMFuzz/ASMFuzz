public class MyJVMTest_10721 {

    static int[] a0 = { 3, 454763230, 0, 0, 7, 0, 6, 0, 8, 0 };

    static int[] a1 = { 5, 0, 9, 0, 6, 0, 7, 6, 7, 0 };

    static int VALUE = 15;

    int[] test_subc(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] - VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10721().test_subc(a0, a1);
    }
}
