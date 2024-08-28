public class MyJVMTest_2148 {

    static int[] a0 = { 2, 9, 0, 1, 6, 0, 1583555787, 1372340355, 9, 7 };

    static int[] a1 = { 4, 0, 2, 3, 0, 4, 0, 6, 1546432302, 6 };

    static int VALUE = 15;

    int[] test_mulc(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] * VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2148().test_mulc(a0, a1);
    }
}
