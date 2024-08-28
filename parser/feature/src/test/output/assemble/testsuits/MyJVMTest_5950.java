public class MyJVMTest_5950 {

    static int[] a0 = { 0, 1847952252, 0, -1633917844, 0, 9, 3, 0, 3, 7 };

    static int[] a1 = { 0, -1617536380, 0, 0, 0, 0, 8, 0, 0, 2 };

    static int VALUE = 15;

    int[] test_mulc_n(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] * (-VALUE));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5950().test_mulc_n(a0, a1);
    }
}
