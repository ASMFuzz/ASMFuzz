public class MyJVMTest_8669 {

    static long val = -9223372036854775808L;

    long testRorOrLong64(long val) {
        return (val >>> 64) | (val << (64 - 64));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8669().testRorOrLong64(val));
    }
}
