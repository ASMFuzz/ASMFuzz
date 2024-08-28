public class MyJVMTest_18067 {

    static int idx = 0;

    static long[] array = new long[10];

    static boolean[] array3 = new boolean[1000];

    int test_after_6(int idx) {
        for (int i = 0; i < 1000; i++) {
            array[idx] = i;
            if (array3[i]) {
                return;
            }
        }
        return idx;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18067().test_after_6(idx);
    }
}
