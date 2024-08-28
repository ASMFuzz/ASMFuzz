public class MyJVMTest_2815 {

    static long a = 9223372036854775807L;

    static long b = -9223372036854775808L;

    static long c = 0;

    long test(long a, long b, long c) {
        return a * b - c * a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2815().test(a, b, c));
    }
}
