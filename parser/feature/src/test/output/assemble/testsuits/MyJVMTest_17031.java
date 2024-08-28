public class MyJVMTest_17031 {

    static int stop = 1555670286;

    static int[] array = { 0, 4, 3, 130341688, 2, 0, 0, 9, 0, -579443808 };

    static int offset = 0;

    static boolean[] flags = { false, false, true, false, false, false, false, false, false, true };

    int test1(int stop, int[] array, int offset, boolean[] flags) {
        if (array == null) {
        }
        int res = 0;
        for (int i = 0; i < stop; i++) {
            if (flags[i]) {
                res += array[2 * i + offset];
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17031().test1(stop, array, offset, flags));
    }
}
