public class MyJVMTest_6178 {

    static int[] src = { 1581159936, 0, -1962398425, 9, -702841874, 7, 0, 3, 7, 1 };

    int test1(int[] src) {
        int[] dst = new int[10];
        System.arraycopy(src, 0, dst, 0, 10);
        src[1] = 0x42;
        return dst[1];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6178().test1(src));
    }
}
