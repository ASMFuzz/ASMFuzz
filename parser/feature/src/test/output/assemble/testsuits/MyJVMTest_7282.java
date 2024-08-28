public class MyJVMTest_7282 {

    static int idx = -881423641;

    static long[] array = new long[10];

    int test_before_2(int idx) {
        for (int i = 0; i < 1000; i++) {
            array[idx] = 999;
            array[i % 2] = 0;
        }
        return idx;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7282().test_before_2(idx);
    }
}
