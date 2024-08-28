public class MyJVMTest_12041 {

    static int stop = 0;

    static boolean[] flags1 = { false, false, false, false, false, true, true, false, false, true };

    static boolean flag2 = false;

    static boolean[] flags3 = { false, false, true, false, true, false, false, true, true, true };

    static int inc = 2;

    void test_helper(int stop, boolean[] flags1, boolean flag2) {
        for (int i = 0; i < stop; i++) {
            if (flags1[i]) {
                return;
            }
            if (flag2) {
            }
        }
    }

    int test(int stop, boolean[] flags1, boolean flag2, boolean[] flags3, int inc) {
        for (int j = 0; j < 100; j += inc) {
            if (flags3[j]) {
                test_helper(stop, flags1, flag2);
            }
        }
        return inc;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12041().test(stop, flags1, flag2, flags3, inc);
    }
}
