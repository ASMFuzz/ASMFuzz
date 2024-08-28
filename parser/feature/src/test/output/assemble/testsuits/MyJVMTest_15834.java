public class MyJVMTest_15834 {

    static long a = 9223372036854775807L;

    static long b = -9223372036854775808L;

    boolean test_isGe(long a, long b) {
        return a >= b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15834().test_isGe(a, b));
    }
}
