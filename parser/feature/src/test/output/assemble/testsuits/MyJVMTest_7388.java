public class MyJVMTest_7388 {

    static int[] a0 = { 3, 0, 0, 0, 912203241, 9, 195967213, 8, -856381550, 2 };

    static int[] a1 = { 9, 8, 8, 3, 824154382, 0, 4, 0, 2, 6 };

    static int b = 4;

    int[] test_andv(int[] a0, int[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] & b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7388().test_andv(a0, a1, b);
    }
}
