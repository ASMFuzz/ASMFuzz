public class MyJVMTest_3883 {

    static long a = 9223372036854775807L;

    static long b = -9223372036854775808L;

    long test_ushr(long a, long b) {
        return a >>> b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3883().test_ushr(a, b));
    }
}
