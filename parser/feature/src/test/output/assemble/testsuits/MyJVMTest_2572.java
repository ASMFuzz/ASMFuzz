public class MyJVMTest_2572 {

    static long val = 2828669473799180401L;

    long testRorOrLong1Orn(long val) {
        return val | (-1 ^ ((val >>> 1) | (val << (64 - 1))));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2572().testRorOrLong1Orn(val));
    }
}
