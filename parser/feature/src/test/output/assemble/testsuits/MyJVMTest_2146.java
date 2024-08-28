public class MyJVMTest_2146 {

    static int[] a0 = { 2, 0, 4, 9, 1, -699204708, 0, 8, 0, 0 };

    static int[] a1 = { -1011466570, 0, 6, -1651756856, 0, 3, 1784073025, 5, 2, 6 };

    static int b = 8;

    int[] test_srlv(int[] a0, int[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] >>> b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2146().test_srlv(a0, a1, b);
    }
}
