public class MyJVMTest_16227 {

    static long i = 9223372036854775807L;

    static long _l = 0L;

    long test_long_reversed(long i) {
        return Long.reverseBytes(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16227().test_long_reversed(i));
    }
}
