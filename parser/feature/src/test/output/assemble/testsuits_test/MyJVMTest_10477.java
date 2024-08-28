public class MyJVMTest_10477 {

    static int idx = 3;

    static long[] array = new long[10];

    static int[] array4 = new int[1000];

    int test_after_7(int idx) {
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j <= 42; j++) {
                array4[i] = j;
            }
        }
        return idx;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10477().test_after_7(idx);
    }
}
