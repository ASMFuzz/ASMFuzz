public class MyJVMTest_7304 {

    static int[] src = { 8, 1697490371, 0, 4, 8, 0, 0, 442844774, 3, 0 };

    static int[] dst = { 2, 0, 7, 0, 5, 1735147100, 9, -1867337065, -269228782, 3 };

    int test1(int[] src, int[] dst) {
        System.arraycopy(src, 5, dst, 0, 10);
        return dst[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7304().test1(src, dst));
    }
}
