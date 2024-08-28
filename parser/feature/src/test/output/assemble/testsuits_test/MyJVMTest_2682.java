public class MyJVMTest_2682 {

    static int[] a = { 0, -1571079326, 0, 6, 0, -90835595, 1, -1144435085, 8, 0 };

    static int[] b = { 8, -1595383746, 7, 4, -481673296, 591603399, 0, 6, 6, 3 };

    static int[] c = { 0, 7, 7, 7, 3, 0, 6, 1438328429, 5, 959639679 };

    static int[] d = { 1639242010, 6, -1235327938, 8, 4, 5, -233976246, -1680783511, -835190792, 5 };

    int orReductionImplement(int[] a, int[] b, int[] c, int[] d) {
        int total = 0;
        for (int i = 0; i < a.length; i++) {
            d[i] = (a[i] * b[i]) + (a[i] * c[i]) + (b[i] * c[i]);
            total |= d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2682().orReductionImplement(a, b, c, d));
    }
}
