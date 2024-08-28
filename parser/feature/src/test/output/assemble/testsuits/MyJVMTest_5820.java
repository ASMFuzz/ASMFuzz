public class MyJVMTest_5820 {

    static int idx = 7;

    static long[] array = new long[10];

    int test_after_1(int idx) {
        for (int i = 0; i < 1000; i++) {
            array[idx] = i;
        }
        return idx;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5820().test_after_1(idx);
    }
}
