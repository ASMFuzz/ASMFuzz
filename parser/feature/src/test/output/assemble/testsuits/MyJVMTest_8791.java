public class MyJVMTest_8791 {

    static long val = 9223372036854775807L;

    long testRorOrLong1Eor(long val) {
        return val ^ ((val >>> 1) | (val << (64 - 1)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8791().testRorOrLong1Eor(val));
    }
}
