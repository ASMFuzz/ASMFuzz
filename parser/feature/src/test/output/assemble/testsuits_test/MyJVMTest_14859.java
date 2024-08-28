public class MyJVMTest_14859 {

    static int idx = 0;

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
        new MyJVMTest_14859().test_after_2(idx);
    }
}
