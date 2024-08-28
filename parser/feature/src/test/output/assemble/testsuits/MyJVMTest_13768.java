public class MyJVMTest_13768 {

    static long val = 0;

    long testRorOrLong1Or(long val) {
        return val | ((val >>> 1) | (val << (64 - 1)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13768().testRorOrLong1Or(val));
    }
}
