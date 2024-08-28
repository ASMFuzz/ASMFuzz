public class MyJVMTest_6295 {

    static A a = null;

    static int[] array = { 0, 6, 8, 1, 0, 0, 0, 0, 5, 6 };

    void test2_helper(int[] array, int k, int j) {
        if (k == 2) {
            array[0] = j;
        }
    }

    static int field = 0;

    static int barrier = 7;

    int test2(A a, int[] array) {
        int ignore = a.field;
        int res = 1;
        int k = 0;
        for (k = 0; k < 2; k++) {
        }
        for (int i = 0; i < 10; i++) {
            barrier = 1;
            for (int j = 0; j < 2000; j++) {
                test2_helper(array, k, j);
                res *= j;
            }
        }
        return a.field + res + a.field * 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6295().test2(a, array));
    }
}
