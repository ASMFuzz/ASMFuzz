public class MyJVMTest_8820 {

    static long val = 0;

    long testRorOrLong1(long val) {
        return (val >>> 1) | (val << (64 - 1));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8820().testRorOrLong1(val));
    }
}
