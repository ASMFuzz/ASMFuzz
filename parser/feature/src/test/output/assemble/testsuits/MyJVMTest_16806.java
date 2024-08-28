public class MyJVMTest_16806 {

    static int idx = 0;

    static long[] array = new long[10];

    int test_before_2(int idx) {
        for (int i = 0; i < 1000; i++) {
            array[idx] = 999;
            array[i % 2] = 0;
        }
        return idx;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16806().test_before_2(idx);
    }
}
