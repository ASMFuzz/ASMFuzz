public class MyJVMTest_188 {

    static int idx = 8;

    static long[] array = new long[10];

    int test_after_4(int idx) {
        for (int i = 0; i < 1000; i++) {
            if (array[0] == -2) {
                break;
            }
            array[idx] = i;
        }
        return idx;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_188().test_after_4(idx);
    }
}
