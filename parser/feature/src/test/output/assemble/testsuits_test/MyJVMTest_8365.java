public class MyJVMTest_8365 {

    static int[] a0 = { 4, 9, 170758508, 6, 1, 0, 0, 5, -1963251335, 8 };

    static int[] a1 = { 0, 0, 0, 9, 5, 6, -1148792611, 0, 8, 1 };

    static int[] a2 = { 0, 0, 4, 1355396395, 0, 3, 0, 0, 8, 7 };

    int[] test_adda(int[] a0, int[] a1, int[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] + a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8365().test_adda(a0, a1, a2);
    }
}
