public class MyJVMTest_1111 {

    static Object test_dummy = 0;

    int test1() {
        int[] src = new int[10];
        test_dummy = src;
        int[] dst = new int[10];
        src[1] = 0x42;
        System.arraycopy(src, 1, dst, 1, 9);
        return dst[1];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1111().test1());
    }
}
