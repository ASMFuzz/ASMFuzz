public class MyJVMTest_6981 {

    static int[] a0 = { 172638849, 2, 4, 0, 0, 8, 296659158, 0, 0, -1948682555 };

    static int[] a1 = { 0, 261215647, 0, 3, 0, 9, 0, 0, 1, 6 };

    static int b = 0;

    int[] test_orv(int[] a0, int[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] | b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6981().test_orv(a0, a1, b);
    }
}
