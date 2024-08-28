public class MyJVMTest_1504 {

    static int[] a0 = { 7, 4, 0, 4, 8, 0, 0, 910871949, 6, 2 };

    static int[] a1 = { 3, 0, 4, 0, -1584115252, 1395919070, 8, 8, 8, 316302448 };

    static int VALUE = 15;

    int[] test_subc(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] - VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1504().test_subc(a0, a1);
    }
}
