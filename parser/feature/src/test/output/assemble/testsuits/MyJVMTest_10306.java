public class MyJVMTest_10306 {

    static Object test_dummy = 8;

    int test1() {
        int[] src = new int[10];
        test_dummy = src;
        int[] dst = new int[10];
        src[1] = 0x42;
        System.arraycopy(src, 1, dst, 1, 9);
        return dst[1];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10306().test1());
    }
}
