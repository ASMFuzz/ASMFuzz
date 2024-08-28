public class MyJVMTest_9604 {

    static int[] a = { -1068405573, 0, 4, 0, 0, -1104426101, 3, -98788188, 6, 8 };

    static int[] b = { 929336323, 2, -1264395374, -1829193668, 51365301, 1921905207, 6, 9, 0, 8 };

    static int[] c = { -1486991738, -1733752895, 6, 0, 0, -1684445911, 0, 3, 0, 0 };

    static int[] d = { 7, -1498267060, 0, 0, 0, 0, 3, -1363523389, 2, 1021023619 };

    int xorReductionImplement(int[] a, int[] b, int[] c, int[] d) {
        int total = -1;
        for (int i = 0; i < a.length; i++) {
            d[i] = (a[i] * b[i]) + (a[i] * c[i]) + (b[i] * c[i]);
            total ^= d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9604().xorReductionImplement(a, b, c, d));
    }
}
