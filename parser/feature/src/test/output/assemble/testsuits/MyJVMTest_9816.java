public class MyJVMTest_9816 {

    static int[] src = { 6, -355083813, 0, 3, 5, 1, 5, 7, 4, 1 };

    int test2(int[] src) {
        System.arraycopy(src, 0, src, 0, 10);
        return src[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9816().test2(src));
    }
}
