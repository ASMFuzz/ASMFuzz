public class MyJVMTest_16338 {

    static long val = 0;

    long testRorOrLong64(long val) {
        return (val >>> 64) | (val << (64 - 64));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16338().testRorOrLong64(val));
    }
}
