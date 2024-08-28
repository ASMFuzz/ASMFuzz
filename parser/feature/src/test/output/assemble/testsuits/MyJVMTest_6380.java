public class MyJVMTest_6380 {

    static int stop = -104780196;

    static int[] array = { 0, 3, 0, -2008302233, 0, 0, 2091073177, 6, 0, -1169598941 };

    static int offset = 8;

    static boolean[] flags = { false, false, false, true, false, true, true, false, false, true };

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
        System.out.println(new MyJVMTest_6380().test2(stop, array, offset, flags));
    }
}
