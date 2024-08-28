public class MyJVMTest_5431 {

    static int idx = -1370931640;

    static long[] array = new long[10];

    static long[] array2 = new long[10];

    int test_after_2(int idx) {
        for (int i = 0; i < 1000; i++) {
            array[idx] = i;
            array2[i % 10] = i;
        }
        return idx;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5431().test_after_2(idx);
    }
}
