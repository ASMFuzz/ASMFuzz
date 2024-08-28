public class MyJVMTest_8465 {

    static long a = 0;

    static long b = -9223372036854775808L;

    boolean test_isEq(long a, long b) {
        return a == b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8465().test_isEq(a, b));
    }
}
