public class MyJVMTest_520 {

    static int[] a = { 6, 7, 2, 3, 0, 2, 9, -1184253409, -1457073388, 0 };

    static int[] b = { 4, 1508395071, 0, 9, 3, 1, 165450613, 5, 4, -198492516 };

    static int[] c = { -239477079, 551152086, 0, 2, 0, 7, 0, 3, 627438739, 8 };

    static int[] d = { 0, 0, -2628437, 0, 0, 4, 2, 0, 500153756, 6 };

    int mulReductionImplement(int[] a, int[] b, int[] c, int[] d) {
        int total = 1;
        for (int i = 0; i < a.length; i++) {
            d[i] = (a[i] * b[i]) + (a[i] * c[i]) + (b[i] * c[i]);
            total = total * d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_520().mulReductionImplement(a, b, c, d));
    }
}
