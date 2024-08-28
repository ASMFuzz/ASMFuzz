public class MyJVMTest_3664 {

    static int[] src = { 0, 5, 3, 0, 2, 8, 8, 9, 0, 3 };

    int test2(int[] src) {
        int[] dst = (int[]) src.clone();
        src[1] = 0x42;
        return dst[1];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3664().test2(src));
    }
}
