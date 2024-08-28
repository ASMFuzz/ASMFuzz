public class MyJVMTest_11843 {

    static int idx = 9;

    static long[] array = new long[10];

    int test_before_5(int idx) {
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0) {
                array[idx] = 999;
            }
        }
        return idx;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11843().test_before_5(idx);
    }
}
