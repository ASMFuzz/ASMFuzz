public class MyJVMTest_16512 {

    static long src1 = 6860767685010700904L;

    static long src2 = -9223372036854775808L;

    long andnq(long src1, long src2) {
        return ~src1 & src2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16512().andnq(src1, src2));
    }
}
