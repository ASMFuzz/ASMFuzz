public class MyJVMTest_11481 {

    static long val = 9223372036854775807L;

    long testRorOrLong63(long val) {
        return (val >>> 63) | (val << (64 - 63));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11481().testRorOrLong63(val));
    }
}
