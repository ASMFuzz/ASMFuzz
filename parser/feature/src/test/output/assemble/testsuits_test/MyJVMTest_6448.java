public class MyJVMTest_6448 {

    static int[] a = { 1, 4, 0, 0, 3, 4, 907175766, 1442696684, 0, -376773492 };

    int[] test_ci(int[] a) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6448().test_ci(a);
    }
}
