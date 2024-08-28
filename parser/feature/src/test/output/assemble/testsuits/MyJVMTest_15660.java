public class MyJVMTest_15660 {

    static int[] a = { 817896553, 194133596, 3, -1059136558, 1, 7, 9, 1011210248, 1, 8 };

    static int[] b = { 0, 0, 4, 8, 8, 6, 2028978030, 0, 0, 0 };

    static int[] c = { 4, 7, 330592211, 0, 1, 7, 3145373, 1782077205, 0, 4 };

    static int[] d = { -1751751268, 1, 0, 0, 0, 0, 8, 9, 6, 0 };

    int andReductionImplement(int[] a, int[] b, int[] c, int[] d) {
        int total = -1;
        for (int i = 0; i < a.length; i++) {
            d[i] = (a[i] * b[i]) + (a[i] * c[i]) + (b[i] * c[i]);
            total &= d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15660().andReductionImplement(a, b, c, d));
    }
}
