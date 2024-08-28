public class MyJVMTest_7332 {

    static int[] a0 = { 9, -1330308869, 5, 2, -1087756739, 0, 0, 5, 2, 0 };

    static int[] a1 = { 0, 0, 5, 5, 3, 8, -568210218, 6, 0, 1 };

    static int VALUE = 15;

    int[] test_srac(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] >> VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7332().test_srac(a0, a1);
    }
}
