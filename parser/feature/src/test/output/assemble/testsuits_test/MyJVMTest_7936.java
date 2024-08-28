public class MyJVMTest_7936 {

    static int idx = 5;

    static long[] array = new long[10];

    int test_before_4(int idx) {
        for (int i = 0; i < 1000; i++) {
            if (idx / (i + 1) > 0) {
                return;
            }
            array[idx] = 999;
        }
        return idx;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7936().test_before_4(idx);
    }
}
