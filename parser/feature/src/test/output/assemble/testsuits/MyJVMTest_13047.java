public class MyJVMTest_13047 {

    static int[] src_array = { 7, 1107683785, 4, 1084256767, 8, 6, 8, 8, 0, 4 };

    static int[] dst_array = { 0, 0, 0, 0, 9, 4, 7, 5, 693991210, 417215413 };

    static int l = 1522428594;

    int test1(int[] src_array, int[] dst_array, int l) {
        for (int i = 0; i < l; i++) {
            dst_array[i + 250] = src_array[i + 250];
        }
        return l;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13047().test1(src_array, dst_array, l);
    }
}
