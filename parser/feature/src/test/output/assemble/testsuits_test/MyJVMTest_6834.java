public class MyJVMTest_6834 {

    static long val = -2129600546532359673L;

    long testRorOrLong64(long val) {
        return (val >>> 64) | (val << (64 - 64));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6834().testRorOrLong64(val));
    }
}
