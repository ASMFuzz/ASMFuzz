public class MyJVMTest_838 {

    static long a = -2984344041264132582L;

    static long b = -9223372036854775808L;

    static long c = 9223372036854775807L;

    long test(long a, long b, long c) {
        return a * b - b * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_838().test(a, b, c));
    }
}
