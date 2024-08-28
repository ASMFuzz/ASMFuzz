public class MyJVMTest_142 {

    static int idx = -352103702;

    static long[] array = new long[10];

    int test_stores_2(int idx) {
        array[idx + 0] = 0;
        array[idx + 1] = 1;
        array[idx + 2] = 2;
        array[idx + 0] = 0;
        array[idx + 1] = 1;
        array[idx + 2] = 2;
        return idx;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_142().test_stores_2(idx);
    }
}
