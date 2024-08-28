public class MyJVMTest_9290 {

    static int idx = 7;

    static long[] array = new long[10];

    int test_stores_2(int idx) {
        array[idx + 0] = 0;
        array[idx + 1] = 1;
        array[idx + 2] = 2;
        array[idx + 0] = 0;
        array[idx + 1] = 1;
        array[idx + 2] = 2;
        return idx;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9290().test_stores_2(idx);
    }
}
