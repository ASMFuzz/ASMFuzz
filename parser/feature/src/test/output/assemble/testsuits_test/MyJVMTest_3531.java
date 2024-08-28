public class MyJVMTest_3531 {

    static byte[] src_array = { -6, 3, 115, 104, -7, 69, -77, 31, 59, -13 };

    static byte[] dst_array = { 119, 92, -77, 30, 67, -35, -19, 31, -118, -102 };

    static int l = 616633833;

    int test2(byte[] src_array, byte[] dst_array, int l) {
        for (int i = 0; i < l; i++) {
            dst_array[i + 250] = src_array[i + 250];
        }
        return l;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3531().test2(src_array, dst_array, l);
    }
}
