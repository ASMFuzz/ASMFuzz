public class MyJVMTest_3710 {

    static int[] src_array = { 2, 3, 422854394, 0, 4, 0, 0, -1124865280, 2, 3 };

    static int[] dst_array = { 5, 0, 0, 0, 0, 7, 6, 0, 1, 638125195 };

    static int l = 3;

    int test1(int[] src_array, int[] dst_array, int l) {
        for (int i = 0; i < l; i++) {
            dst_array[i + 250] = src_array[i + 250];
        }
        return l;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3710().test1(src_array, dst_array, l);
    }
}
