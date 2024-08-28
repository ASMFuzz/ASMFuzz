public class MyJVMTest_10017 {

    static long a = -9223372036854775808L;

    static long b = 9223372036854775807L;

    static long c = 0;

    long test(long a, long b, long c) {
        return a * b - b * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10017().test(a, b, c));
    }
}
