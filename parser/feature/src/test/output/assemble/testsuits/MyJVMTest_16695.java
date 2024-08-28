public class MyJVMTest_16695 {

    static int[] a = { 5, 0, 3, 6, 0, 0, 3, 104766117, 7, 1 };

    static int[] b = { -1515163783, 6, 0, 9, 4, 8, 5, 7, 3, 7 };

    static int[] c = { 1108344624, 4, 0, 1, 9, 5, 1994570034, 0, 8, 4 };

    static int[] d = { -1582672979, 5, 2, 9, 6, 6, -995785699, -517539669, 7, 8 };

    static int total = 6;

    int sumReductionImplement(int[] a, int[] b, int[] c, int[] d, int total) {
        for (int i = 0; i < a.length; i++) {
            d[i] = (a[i] * b[i]) + (a[i] * c[i]) + (b[i] * c[i]);
            total += d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16695().sumReductionImplement(a, b, c, d, total));
    }
}
