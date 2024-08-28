public class MyJVMTest_2233 {

    static int stop = -1973871160;

    static boolean[] flags1 = { true, false, true, false, true, true, true, false, false, true };

    static boolean flag2 = false;

    boolean test_helper(int stop, boolean[] flags1, boolean flag2) {
        for (int i = 0; i < stop; i++) {
            if (flags1[i]) {
                return;
            }
            if (flag2) {
            }
        }
        return flag2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2233().test_helper(stop, flags1, flag2);
    }
}
