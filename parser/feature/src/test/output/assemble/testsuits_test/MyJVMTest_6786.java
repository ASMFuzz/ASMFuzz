public class MyJVMTest_6786 {

    static int[] a = { 0, 8, 953121166, 1, 5, -1673570284, 4, 5, -45070877, 3 };

    static int[] b = { 2, 1, 2, 3, 3, 793020018, 8, 4, 9, 0 };

    int[] test_2ci(int[] a, int[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6786().test_2ci(a, b);
    }
}
