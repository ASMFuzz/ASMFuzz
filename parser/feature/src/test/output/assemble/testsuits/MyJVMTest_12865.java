public class MyJVMTest_12865 {

    static byte[] src_array = { -111, 24, -125, 4, -30, 66, -67, -104, -99, 78 };

    static byte[] dst_array = { 61, -4, 12, 55, -104, 3, -93, 59, -26, -110 };

    static int l = 4;

    int test2(byte[] src_array, byte[] dst_array, int l) {
        for (int i = 0; i < l; i++) {
            dst_array[i + 250] = src_array[i + 250];
        }
        return l;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12865().test2(src_array, dst_array, l);
    }
}
