public class MyJVMTest_15403 {

    static int[] a0 = { 0, 8, 1261158704, 1980216559, 0, 0, 0, 0, 6, -1739233204 };

    static int[] a1 = { 0, 9, 6, 3, 8, 0, 4, 597477287, -1248225748, 0 };

    static int VALUE = 15;

    int[] test_mulc_n(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] * (-VALUE));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15403().test_mulc_n(a0, a1);
    }
}
