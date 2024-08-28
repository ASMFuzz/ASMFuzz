public class MyJVMTest_9107 {

    static long val = 0;

    long testRorOrLong1Eon(long val) {
        return val ^ (-1 ^ ((val >>> 1) | (val << (64 - 1))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9107().testRorOrLong1Eon(val));
    }
}
