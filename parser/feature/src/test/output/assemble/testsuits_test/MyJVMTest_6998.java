public class MyJVMTest_6998 {

    static long src1 = -9223372036854775808L;

    static long src2 = 9223372036854775807L;

    long andnq(long src1, long src2) {
        return ~src1 & src2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6998().andnq(src1, src2));
    }
}
