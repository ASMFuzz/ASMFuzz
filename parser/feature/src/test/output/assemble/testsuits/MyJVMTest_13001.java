public class MyJVMTest_13001 {

    static int[] src = { 2, 9, 1, 0, -1458316388, 0, 6, 8, 0, 9 };

    int test2(int[] src) {
        int[] dst = (int[]) src.clone();
        src[1] = 0x42;
        return dst[1];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13001().test2(src));
    }
}
