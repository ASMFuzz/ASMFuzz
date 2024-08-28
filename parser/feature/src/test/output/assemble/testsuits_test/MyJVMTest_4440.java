public class MyJVMTest_4440 {

    static long val = 9223372036854775807L;

    long testRorOrLong63Eor(long val) {
        return val ^ ((val >>> 63) | (val << (64 - 63)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4440().testRorOrLong63Eor(val));
    }
}
