public class MyJVMTest_12840 {

    static long val = 525439601999796797L;

    long testRorOrLong63Eon(long val) {
        return val ^ (-1 ^ ((val >>> 63) | (val << (64 - 63))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12840().testRorOrLong63Eon(val));
    }
}
