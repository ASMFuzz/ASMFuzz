public class MyJVMTest_11111 {

    static int idx = 2;

    static long[] array = new long[10];

    int test_after_3(int idx) {
        for (int i = 0; i < 1000; i++) {
            array[idx] = i;
            if (array[0] == -1) {
                break;
            }
        }
        return idx;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11111().test_after_3(idx);
    }
}
