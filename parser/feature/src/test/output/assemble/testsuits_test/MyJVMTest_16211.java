public class MyJVMTest_16211 {

    static int[] a0 = { 0, 6, 237801819, 5, 7, 3, 34105489, 3, 3, 0 };

    static int[] a1 = { -1302869439, 0, 0, -613542613, 0, 0, 22549447, 0, 2, 6 };

    static int VALUE = 15;

    int[] test_addc(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] + VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16211().test_addc(a0, a1);
    }
}
