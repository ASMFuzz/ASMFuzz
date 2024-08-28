public class MyJVMTest_17518 {

    static int idx = 2;

    static long[] array = new long[10];

    int test_after_5(int idx) {
        for (int i = 0; i < 1000; i++) {
            array[idx] = i;
            array[idx + 1] = i;
            array[idx + 2] = i;
            array[idx + 3] = i;
            array[idx + 4] = i;
            array[idx + 5] = i;
        }
        return idx;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17518().test_after_5(idx);
    }
}
