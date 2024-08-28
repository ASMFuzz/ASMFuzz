public class MyJVMTest_16830 {

    static int[] src = { 0, 0, 0, -345191150, -1303238421, 8, 2, 0, 0, 0 };

    static int[] dst = { 4, -912134857, 0, -1939932333, 1, 791684978, 0, 0, 917230370, -1699421755 };

    int test1(int[] src, int[] dst) {
        System.arraycopy(src, 5, dst, 0, 10);
        return dst[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16830().test1(src, dst));
    }
}
