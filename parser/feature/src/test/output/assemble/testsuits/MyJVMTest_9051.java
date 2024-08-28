public class MyJVMTest_9051 {

    static long val = -7224986050787980L;

    long testRorOrLong16Orn(long val) {
        return val | (-1 ^ ((val >>> 16) | (val << (64 - 16))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9051().testRorOrLong16Orn(val));
    }
}
