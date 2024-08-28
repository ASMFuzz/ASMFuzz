public class MyJVMTest_8668 {

    static long a = -9223372036854775808L;

    static long b = -9223372036854775808L;

    static long c = 4300500469842459638L;

    long test(long a, long b, long c) {
        return a * b + b * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8668().test(a, b, c));
    }
}
