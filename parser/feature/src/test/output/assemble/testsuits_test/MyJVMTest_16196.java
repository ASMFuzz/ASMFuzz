public class MyJVMTest_16196 {

    static int idx = 7;

    static long[] array = new long[10];

    int test_before_1(int idx) {
        for (int i = 0; i < 1000; i++) {
            array[idx] = 999;
        }
        return idx;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16196().test_before_1(idx);
    }
}
