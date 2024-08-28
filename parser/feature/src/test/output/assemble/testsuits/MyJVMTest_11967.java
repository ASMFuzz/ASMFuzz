public class MyJVMTest_11967 {

    static int[] a = { 0, 5, 5, 2, 6, 2, 0, 9, 0, 0 };

    static int[] b = { 9, 1, 3, 5, 5, 0, 4, 0, 0, 2 };

    static int[] c = { 231561060, -1330385817, 9, 6, 9, 9, 0, 0, 0, 4 };

    static int[] d = { 4, 6, 6, 2, 8, 3, 1, 4605295, 2, 9 };

    int orReductionImplement(int[] a, int[] b, int[] c, int[] d) {
        int total = 0;
        for (int i = 0; i < a.length; i++) {
            d[i] = (a[i] * b[i]) + (a[i] * c[i]) + (b[i] * c[i]);
            total |= d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11967().orReductionImplement(a, b, c, d));
    }
}
