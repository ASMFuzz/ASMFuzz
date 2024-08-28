public class MyJVMTest_3910 {

    static int[] a0 = { -1959319923, 0, 0, 6, 9, 9, 0, -503464158, -103684698, 0 };

    static int[] a1 = { 0, 7, 0, -1192215550, 8, 3, 1261978391, 0, 0, 1379150970 };

    static int VALUE = 15;

    int[] test_srlc_n(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] >>> (-VALUE));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3910().test_srlc_n(a0, a1);
    }
}
