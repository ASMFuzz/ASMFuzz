public class MyJVMTest_16525 {

    static int[] a0 = { 0, 9, 6, 8, 0, 3, 2, 9, 1028749554, 9 };

    static int[] a1 = { 0, 0, 2, 2, -789535206, 0, 1837733177, 0, 8, 5 };

    static int[] a2 = { -943839722, 0, 0, 9, 2049050940, 8, -874868529, 5, 0, -212819432 };

    int[] test_suba(int[] a0, int[] a1, int[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] - a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16525().test_suba(a0, a1, a2);
    }
}
