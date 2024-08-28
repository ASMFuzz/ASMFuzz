public class MyJVMTest_1274 {

    static int idx = 0;

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
        new MyJVMTest_1274().test_after_7(idx);
    }
}
