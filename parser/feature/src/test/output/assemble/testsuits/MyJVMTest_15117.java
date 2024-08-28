public class MyJVMTest_15117 {

    static int[] a0 = { 0, -2066195462, 575089709, 809893598, 2, 10804982, 14038868, -1358395663, 0, -983326985 };

    static int[] a1 = { 689842956, 1, 3, 0, 0, 5, 0, 0, 6, 5 };

    static int b = 8;

    int[] test_srav(int[] a0, int[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] >> b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15117().test_srav(a0, a1, b);
    }
}
