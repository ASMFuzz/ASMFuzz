public class MyJVMTest_6187 {

    static int[] a = { -1653082144, 3, 2, 5, 8, 4, 6, 0, 8, 0 };

    static int[] b = { 2, 1153276151, -350423650, 2, 7, 0, 4, 7, 8, -1841823882 };

    static int[] c = { 4, 4, 2, 1, 0, 7, 0, 1899128861, 7, 0 };

    static int[] d = { 6, -746410445, 3, 0, 0, 9, 0, 0, -2095723495, 2 };

    int andReductionImplement(int[] a, int[] b, int[] c, int[] d) {
        int total = -1;
        for (int i = 0; i < a.length; i++) {
            d[i] = (a[i] * b[i]) + (a[i] * c[i]) + (b[i] * c[i]);
            total &= d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6187().andReductionImplement(a, b, c, d));
    }
}
