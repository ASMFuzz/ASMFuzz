public class MyJVMTest_9683 {

    static int[] a = { 7, 0, 0, 0, 0, 1, -548722195, 0, 0, 3 };

    static int[] b = { 0, 9, 8, 0, 9, 813612592, -1020394418, 5, 1, 0 };

    static int[] c = { 4, 0, 0, -1390459053, 0, 1, 1246117341, 1, 3, 1 };

    static int[] d = { 896194551, 0, 0, -1821580640, 2, 1775040609, 339672248, 0, -855326362, 0 };

    int mulReductionImplement(int[] a, int[] b, int[] c, int[] d) {
        int total = 1;
        for (int i = 0; i < a.length; i++) {
            d[i] = (a[i] * b[i]) + (a[i] * c[i]) + (b[i] * c[i]);
            total = total * d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9683().mulReductionImplement(a, b, c, d));
    }
}
