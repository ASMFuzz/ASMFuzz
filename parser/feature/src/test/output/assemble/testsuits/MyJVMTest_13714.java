public class MyJVMTest_13714 {

    static int[] a = { -865650091, 1, 0, 4, 0, 8, -543221070, -216703996, 8, 0 };

    static int[] b = { 1012435735, 9, 1015856290, 6, 3, 0, 0, 7, 0, 4 };

    static int[] c = { 2, 0, 0, 6, -487494476, 3, 1, -115212908, 419307955, 3 };

    int[] reductionInit2(int[] a, int[] b, int[] c) {
        for (int i = 0; i < a.length; i++) {
            a[i] = 0x11;
            b[i] = 0x12;
            c[i] = 0x13;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13714().reductionInit2(a, b, c);
    }
}
