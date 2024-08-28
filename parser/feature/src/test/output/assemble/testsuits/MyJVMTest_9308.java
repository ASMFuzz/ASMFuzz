public class MyJVMTest_9308 {

    static int[] a = { 0, 1928345135, 8, -1909476612, -782375104, 5, 0, 2, 0, 1033718556 };

    static int[] iArrFld = new int[10];

    int[] init(int[] a) {
        for (int j = 0; j < a.length; j++) {
            a[j] = j;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9308().init(a);
    }
}
