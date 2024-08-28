public class MyJVMTest_2045 {

    static int[] a = { 5, 8, 2, 1, 0, 5, 4, -510090870, 5, 3 };

    static int i = 0;

    static int j = -1572970200;

    int[] swap(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2045().swap(a, i, j);
    }
}
