public class MyJVMTest_15651 {

    static int[] src = { 2, 0, 0, 1, 0, 7, 0, 0, 0, 0 };

    int test1(int[] src) {
        int[] dst = new int[10];
        System.arraycopy(src, 0, dst, 0, 10);
        src[1] = 0x42;
        return dst[1];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15651().test1(src));
    }
}
