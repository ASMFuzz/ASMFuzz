public class MyJVMTest_15861 {

    static int stop = 0;

    static int[] array = { 0, 1820541917, 1, -989742824, 488684910, 0, 939662993, 1132788152, 7, 0 };

    static int offset = 0;

    static boolean[] flags = { true, true, false, false, false, false, true, true, true, false };

    int test2(int stop, int[] array, int offset, boolean[] flags) {
        if (array == null) {
        }
        int res = 0;
        for (int i = 0; i < stop; i++) {
            if (flags[i]) {
                res += array[-2 * i + offset];
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15861().test2(stop, array, offset, flags));
    }
}
