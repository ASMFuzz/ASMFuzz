public class MyJVMTest_16710 {

    static long a = -9223372036854775808L;

    static long b = 0;

    long test_or(long a, long b) {
        return a | b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16710().test_or(a, b));
    }
}
