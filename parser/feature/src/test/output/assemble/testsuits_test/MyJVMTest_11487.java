public class MyJVMTest_11487 {

    static int stop = 3;

    static boolean[] flags1 = { false, true, true, true, true, false, true, true, true, true };

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
        new MyJVMTest_11487().test_helper(stop, flags1, flag2);
    }
}
