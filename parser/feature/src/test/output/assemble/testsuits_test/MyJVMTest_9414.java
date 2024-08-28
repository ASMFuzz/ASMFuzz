public class MyJVMTest_9414 {

    static int[] a = { 1, 2, -1834060001, 2, 1, 2, 0, 1296614728, 0, 9 };

    static int[] b = { 0, 0, 8, 8, 624149836, 97529006, 0, -1072105293, -80701245, 8 };

    static int[] c = { 2, 0, 5, 1, 8, 7, -1058613267, 0, 904520822, 2 };

    static int[] d = { 5, 1, 0, 2, 2093833240, 0, -1370604416, 9, 0, 6 };

    int sumReductionImplement(int[] a, int[] b, int[] c, int[] d) {
        int total = 0;
        for (int i = 0; i < a.length; i++) {
            d[i] = (a[i] * b[i]) + (a[i] * c[i]) + (b[i] * c[i]);
            total += d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9414().sumReductionImplement(a, b, c, d));
    }
}
