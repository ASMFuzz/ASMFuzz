public class MyJVMTest_8787 {

    static long val = -9223372036854775808L;

    long testRorOrLong64Eor(long val) {
        return val ^ ((val >>> 64) | (val << (64 - 64)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8787().testRorOrLong64Eor(val));
    }
}
