public class MyJVMTest_11291 {

    static int[] a = { 4, 7, 9, 3, 3, -226424882, -22837619, 0, 1126779322, 6 };

    static int i = -5933028;

    static int j = 0;

    int[] swap(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11291().swap(a, i, j);
    }
}
