public class MyJVMTest_11461 {

    static long a = -9223372036854775808L;

    static long b = -9223372036854775808L;

    static long c = 9223372036854775807L;

    long test(long a, long b, long c) {
        return a * c + b * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11461().test(a, b, c));
    }
}
