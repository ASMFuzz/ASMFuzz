public class MyJVMTest_9545 {

    static int[] a0 = { 0, -785481604, 0, -1170253886, 0, 0, 3, 9, 0, 2 };

    static int[] a1 = { 1, 7, 272448904, 1, 1, 3, 9, 2106164051, 0, 1672931237 };

    static int VALUE = 15;

    int[] test_divc(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] / VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9545().test_divc(a0, a1);
    }
}
