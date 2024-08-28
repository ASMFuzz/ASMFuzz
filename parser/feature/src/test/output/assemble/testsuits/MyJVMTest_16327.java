public class MyJVMTest_16327 {

    static int[] a = { 0, 0, 596270126, 9, 9, 0, 0, -996935360, 1, 1498767488 };

    static int[] b = { 0, 0, 3, -641498307, 0, 8, 0, 0, 5, -600909837 };

    int[] test_cp(int[] a, int[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16327().test_cp(a, b);
    }
}
