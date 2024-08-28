public class MyJVMTest_7172 {

    static int[] a = { 9, 9, 578585967, 4, 2, -1638120138, 3, 3, 0, -1992616234 };

    static int[] b = { 4, 0, 6, -1140088039, 0, 6, -297983995, 3, 3, 1 };

    static int[] c = { -1447684059, 1, 5, 1, 1, 2, 1, 8, 0, 5 };

    static int[] d = { 2100415868, 8, 6, 7, 1, 7, 1928229319, -1757873092, -686464174, 7 };

    static int total = 812216080;

    int sumReductionImplement(int[] a, int[] b, int[] c, int[] d, int total) {
        for (int i = 0; i < a.length; i++) {
            d[i] = (a[i] * b[i]) + (a[i] * c[i]) + (b[i] * c[i]);
            total += d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7172().sumReductionImplement(a, b, c, d, total));
    }
}
