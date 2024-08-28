public class MyJVMTest_2656 {

    static int idx = 0;

    static long[] array = new long[10];

    static byte[] byte_array = new byte[10];

    int test_stores_3(int idx) {
        byte_array[idx + 0] = 0;
        byte_array[idx + 1] = 1;
        byte_array[idx + 2] = 2;
        byte_array[idx + 0] = 0;
        byte_array[idx + 1] = 1;
        byte_array[idx + 2] = 2;
        return idx;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2656().test_stores_3(idx);
    }
}
