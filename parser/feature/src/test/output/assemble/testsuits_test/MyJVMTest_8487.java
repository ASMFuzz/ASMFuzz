public class MyJVMTest_8487 {

    static int[] a0 = { 2, -966179740, 0, 9, 9, 2, 0, 0, -778162076, 0 };

    static int[] a1 = { 6, 1, 0, 5, 0, 2, 0, 0, 31684801, 8 };

    static int VALUE = 15;

    int[] test_divc_n(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] / (-VALUE));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8487().test_divc_n(a0, a1);
    }
}
