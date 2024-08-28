public class MyJVMTest_7433 {

    static int[] dst = { 0, 471743047, -261258856, 7, 9, 0, 0, 9, 3, -1220285672 };

    static int dstPos = 4;

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
        new MyJVMTest_7433().test1(dst, dstPos);
    }
}
