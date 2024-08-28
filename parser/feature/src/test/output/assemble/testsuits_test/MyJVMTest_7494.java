public class MyJVMTest_7494 {

    static int stop = 5;

    static int[] array = { 609047196, -883263526, 6, 9, 3, 9, -1824798695, 9, 7, 0 };

    static int offset = 8;

    static boolean[] flags = { true, false, false, false, true, true, false, true, true, true };

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
        System.out.println(new MyJVMTest_7494().test1(stop, array, offset, flags));
    }
}
