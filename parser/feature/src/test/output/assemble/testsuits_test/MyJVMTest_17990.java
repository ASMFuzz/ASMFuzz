public class MyJVMTest_17990 {

    static long val = -216743171169044278L;

    long testRorOrLong1Eor(long val) {
        return val ^ ((val >>> 1) | (val << (64 - 1)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17990().testRorOrLong1Eor(val));
    }
}
