public class MyJVMTest_263 {

    static int[] a = { 6, 0, 2, 6, -173152807, -129084523, 0, 1820596011, 6, 6 };

    static int[] b = { 0, 1535789156, 1, -670736865, 841893382, 0, 3, 0, -1750989815, 2 };

    static int[] c = { 313041748, 0, 5, 5, 4, 4, 0, 5, 0, -741840325 };

    static int[] d = { 8, 0, 1310256784, 3, 6, 2114771528, 0, 7, 0, 8 };

    int sumReductionImplement(int[] a, int[] b, int[] c, int[] d) {
        int total = 0;
        for (int i = 0; i < a.length; i++) {
            d[i] = (a[i] * b[i]) + (a[i] * c[i]) + (b[i] * c[i]);
            total += d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_263().sumReductionImplement(a, b, c, d));
    }
}
