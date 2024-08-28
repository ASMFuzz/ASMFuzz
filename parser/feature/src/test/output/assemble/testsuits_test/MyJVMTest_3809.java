public class MyJVMTest_3809 {

    static Object test5_src = null;

    int test3() {
        int[] dst = new int[10];
        System.arraycopy(test5_src, 0, dst, 0, 10);
        ((int[]) test5_src)[1] = 0x42;
        System.arraycopy(test5_src, 0, dst, 0, 10);
        return dst[1];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3809().test3());
    }
}
