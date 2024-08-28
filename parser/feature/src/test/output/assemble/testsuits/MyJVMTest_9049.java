public class MyJVMTest_9049 {

    static long val = -2846520938398685865L;

    long testRorOrLong63(long val) {
        return (val >>> 63) | (val << (64 - 63));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9049().testRorOrLong63(val));
    }
}
