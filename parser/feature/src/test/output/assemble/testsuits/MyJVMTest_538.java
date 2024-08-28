public class MyJVMTest_538 {

    static long a = 9223372036854775807L;

    static long b = 1843610730701718622L;

    static long c = -9223372036854775808L;

    long test(long a, long b, long c) {
        return a * b + a * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_538().test(a, b, c));
    }
}
