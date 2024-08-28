public class MyJVMTest_15773 {

    static A a = null;

    static int[] array = { 7, -803660244, 243940609, 1410205594, 5, 9, 3, 0, 0, 1 };

    void test2_helper(int[] array, int k, int j) {
        if (k == 2) {
            array[0] = j;
        }
    }

    static int field = 0;

    static int barrier = -800038875;

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
        System.out.println(new MyJVMTest_15773().test2(a, array));
    }
}
