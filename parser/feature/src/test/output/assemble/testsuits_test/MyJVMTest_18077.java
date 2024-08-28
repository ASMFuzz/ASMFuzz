public class MyJVMTest_18077 {

    static int[] a0 = { 1315880528, 3, 0, 0, 1312412952, 492861161, -592050774, -1404411630, 0, 4 };

    static int[] a1 = { -699681140, 0, 294541167, 4, 4, 2, 0, 1947674684, 859145737, 0 };

    static int VALUE = 15;

    int[] test_divc_n(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] / (-VALUE));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18077().test_divc_n(a0, a1);
    }
}
