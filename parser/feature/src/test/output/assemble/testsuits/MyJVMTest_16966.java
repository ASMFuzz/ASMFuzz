public class MyJVMTest_16966 {

    static int[] dst = { 2023247794, 9, 1872613891, 1558582570, 0, 1, 1, 0, 787063237, 4 };

    static int dstPos = 3;

    void not_inlined() {
    }

    int[] test1(int[] dst, int dstPos) {
        int[] src = new int[4];
        not_inlined();
        src[0] = 1;
        src[1] = 2;
        src[2] = 3;
        src[3] = 4;
        System.arraycopy(src, 0, dst, dstPos, 4);
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16966().test1(dst, dstPos);
    }
}
