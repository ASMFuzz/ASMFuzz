public class MyJVMTest_3506 {

    static long val = 0;

    long testRorOrLong63Eon(long val) {
        return val ^ (-1 ^ ((val >>> 63) | (val << (64 - 63))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3506().testRorOrLong63Eon(val));
    }
}
