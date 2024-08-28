public class MyJVMTest_17946 {

    static int[] a0 = { -1949229221, -1438416520, 6, 3, 6, 0, 5, 9, 450194596, 1456910539 };

    static int[] a1 = { 711004199, 4, 0, 403344589, 0, 0, 7, 0, 8, 5 };

    static int[] a2 = { 1, 3, 0, 7, 0, 0, 8, 9, 2, 8 };

    int[] test_adda(int[] a0, int[] a1, int[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] + a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17946().test_adda(a0, a1, a2);
    }
}
