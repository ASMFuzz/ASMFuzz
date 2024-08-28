public class MyJVMTest_6730 {

    static long i = 0;

    static long _l = 0L;

    long test_long_reversed(long i) {
        return Long.reverseBytes(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6730().test_long_reversed(i));
    }
}
